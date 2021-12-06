package com.mosh.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.entity.MemberOrder;
import com.mosh.ucenter.entity.Member;
import com.mosh.ucenter.entity.vo.MemberVo;
import com.mosh.ucenter.entity.vo.RegisterVo;
import com.mosh.ucenter.mapper.MemberMapper;
import com.mosh.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.utils.exception.LoginException;
import com.mosh.utils.exception.RegisterException;
import com.mosh.utils.jwt.JwtUtils;
import com.mosh.utils.md5.MD5;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-06
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    MemberMapper memberMapper;

    @Resource
    RedisTemplate<String, String> redisTemplate;

    @Override
    public String login(Member member) {
        String mobile = member.getMobile();
        String password = member.getPassword();
        String encrypt = MD5.encrypt(password);

        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new LoginException();
        }
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        member = memberMapper.selectOne(wrapper);

        if (member == null || !encrypt.equals(member.getPassword()) || member.getIsDisabled()) {
            throw new LoginException();
        }
        return JwtUtils.getJwtToken(member.getId(), member.getNickname());
    }

    @Override
    public void register(RegisterVo registerVo) {

        String nickname = registerVo.getNickname();
        String code = registerVo.getCode();
        String password = registerVo.getPassword();
        String mobile = registerVo.getMobile();

        //非空
        if (StringUtils.isEmpty(nickname) || StringUtils.isEmpty(code) ||
                StringUtils.isEmpty(password) || StringUtils.isEmpty(mobile)) {
            throw new RegisterException();
        }

        //验证码合格
        String redisCode = redisTemplate.opsForValue().get(registerVo.getMobile());
        if (!code.equals(redisCode)) {
            throw new RegisterException();
        }

        //手机号不重复
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        if (memberMapper.selectCount(wrapper) != 0) {
            throw new RegisterException();
        }

        Member member = new Member();
        member.setMobile(mobile);
        member.setAvatar("http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132");
        member.setNickname(nickname);
        member.setPassword(MD5.encrypt(password));

        memberMapper.insert(member);
    }

    @Override
    public MemberOrder getMemberOrder(String id) {
        Member member = memberMapper.selectById(id);
        MemberOrder memberOrder = new MemberOrder();
        BeanUtils.copyProperties(member, memberOrder);
        return memberOrder;
    }

    @Override
    public Integer countRegister(String day) {
        return memberMapper.countRegister(day);
    }

    @Override
    public MemberVo getMemberById(String id) {
        Member member = memberMapper.selectById(id);
        if (member == null) {
            return null;
        }
        MemberVo memberVo = new MemberVo();
        BeanUtils.copyProperties(member, memberVo);
        return memberVo;
    }
}

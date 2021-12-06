package com.mosh.ucenter.service;

import com.mosh.entity.MemberOrder;
import com.mosh.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.ucenter.entity.vo.MemberVo;
import com.mosh.ucenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-11-06
 */
public interface MemberService extends IService<Member> {

    String login(Member member);

    void register(RegisterVo registerVo);

    MemberOrder getMemberOrder(String id);

    Integer countRegister(String day);

    MemberVo getMemberById(String id);
}

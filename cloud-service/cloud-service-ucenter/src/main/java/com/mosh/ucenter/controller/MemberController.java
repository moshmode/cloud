package com.mosh.ucenter.controller;


import com.mosh.entity.MemberOrder;
import com.mosh.ucenter.entity.Member;
import com.mosh.ucenter.entity.vo.RegisterVo;
import com.mosh.ucenter.service.MemberService;
import com.mosh.utils.jwt.JwtUtils;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-06
 */
@RestController
@RequestMapping("ucenter/member")
public class MemberController {
    @Resource
    MemberService memberService;

    @PostMapping("login")
    public ResponseEntity login(Member member) {
        String token = memberService.login(member);
        return ResponseEntity.success().data("token", token);
    }

    @PostMapping("register")
    public ResponseEntity register(RegisterVo registerVo) {
        memberService.register(registerVo);
        return ResponseEntity.success();
    }

    @GetMapping("getMemberInfo")
    public ResponseEntity getMemberInfo(HttpServletRequest request) {
        String id = JwtUtils.getMemberIdByJwtToken(request);
        Member memberInfo = memberService.getById(id);
        return ResponseEntity.success().data("memberInfo", memberInfo);
    }
}


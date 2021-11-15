package com.mosh.ucenter.controller.feign;

import com.mosh.entity.MemberOrder;
import com.mosh.ucenter.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/11 13:36
 */
@RestController
@RequestMapping("ucenter/member/feign")
public class MemberFeignController {
    @Resource
    MemberService memberService;

    @GetMapping("order/{id}")
    public MemberOrder getMemberOrder(@PathVariable("id") String id) {
        return memberService.getMemberOrder(id);
    }

    @GetMapping("statistics/register/{day}")
    public Integer countRegister(@PathVariable("day") String day) {
        return memberService.countRegister(day);
    }

}

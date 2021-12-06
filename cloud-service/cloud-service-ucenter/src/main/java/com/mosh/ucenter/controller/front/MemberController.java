package com.mosh.ucenter.controller.front;

import com.mosh.ucenter.service.MemberService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 * 用户中心控制器
 *
 * @author mosh
 * @date 2021/12/5 10:15
 */
@RestController
@RequestMapping("ucenter/member/front")
public class MemberController {

    @Resource
    MemberService memberService;

    @GetMapping("")
    public ResponseEntity getMemberByPage() {
        return ResponseEntity.success();
    }

    @GetMapping("{id}")
    public ResponseEntity getMemberById(@PathVariable("id") String id) {
        return ResponseEntity.success().data("member", memberService.getMemberById(id));
    }

}

package com.mosh.acl.controller;

import com.alibaba.fastjson.JSONObject;
import com.mosh.acl.service.IndexService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/acl/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 根据token获取用户信息
     */
    @GetMapping("info")
    public ResponseEntity info() {
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return ResponseEntity.success().data(userInfo);
    }

    /**
     * 获取菜单
     *
     * @return
     */
    @GetMapping("menu")
    public ResponseEntity getMenu() {
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList = indexService.getMenu(username);
        return ResponseEntity.success().data("permissionList", permissionList);
    }

    @PostMapping("logout")
    public ResponseEntity logout() {
        return ResponseEntity.success();
    }

}

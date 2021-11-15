package com.mosh.acl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.acl.entity.User;
import com.mosh.acl.service.RoleService;
import com.mosh.acl.service.UserService;
import com.mosh.utils.md5.MD5;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/acl/user")
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("{page}/{limit}")
    public ResponseEntity index(
            @PathVariable Long page,
            @PathVariable Long limit,
             User userQueryVo) {
        Page<User> pageParam = new Page<>(page, limit);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(userQueryVo.getUsername())) {
            wrapper.like("username",userQueryVo.getUsername());
        }

        IPage<User> pageModel = userService.page(pageParam, wrapper);
        return ResponseEntity.success().data("items", pageModel.getRecords()).data("total", pageModel.getTotal());
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody User user) {
        user.setPassword(MD5.encrypt(user.getPassword()));
        userService.save(user);
        return ResponseEntity.success();
    }

    @PutMapping("update")
    public ResponseEntity updateById(@RequestBody User user) {
        userService.updateById(user);
        return ResponseEntity.success();
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity remove(@PathVariable String id) {
        userService.removeById(id);
        return ResponseEntity.success();
    }

    @DeleteMapping("batchRemove")
    public ResponseEntity batchRemove(@RequestBody List<String> idList) {
        userService.removeByIds(idList);
        return ResponseEntity.success();
    }

    @GetMapping("/toAssign/{userId}")
    public ResponseEntity toAssign(@PathVariable String userId) {
        Map<String, Object> roleMap = roleService.findRoleByUserId(userId);
        return ResponseEntity.success().data(roleMap);
    }

    @PostMapping("/doAssign")
    public ResponseEntity doAssign(@RequestParam String userId,@RequestParam String[] roleId) {
        roleService.saveUserRoleRealtionShip(userId,roleId);
        return ResponseEntity.success();
    }
}


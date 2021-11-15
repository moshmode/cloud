package com.mosh.acl.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.acl.entity.Role;
import com.mosh.acl.service.RoleService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/acl/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("{page}/{limit}")
    public ResponseEntity index(
            @PathVariable Long page,
            @PathVariable Long limit,
            Role role) {
        Page<Role> pageParam = new Page<>(page, limit);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(role.getRoleName())) {
            wrapper.like("role_name",role.getRoleName());
        }
        roleService.page(pageParam,wrapper);
        return ResponseEntity.success().data("items", pageParam.getRecords()).data("total", pageParam.getTotal());
    }

    @GetMapping("get/{id}")
    public ResponseEntity get(@PathVariable String id) {
        Role role = roleService.getById(id);
        return ResponseEntity.success().data("item", role);
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody Role role) {
        roleService.save(role);
        return ResponseEntity.success();
    }

    @PutMapping("update")
    public ResponseEntity updateById(@RequestBody Role role) {
        roleService.updateById(role);
        return ResponseEntity.success();
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity remove(@PathVariable String id) {
        roleService.removeById(id);
        return ResponseEntity.success();
    }

    @DeleteMapping("batchRemove")
    public ResponseEntity batchRemove(@RequestBody List<String> idList) {
        roleService.removeByIds(idList);
        return ResponseEntity.success();
    }
}


package com.mosh.acl.controller;


import com.mosh.acl.entity.Permission;
import com.mosh.acl.service.PermissionService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 菜单管理
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/acl/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //获取全部菜单
    @GetMapping
    public ResponseEntity indexAllPermission() {
        List<Permission> list =  permissionService.queryAllMenu();
        return ResponseEntity.success().data("children",list);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity remove(@PathVariable String id) {
        permissionService.removeChildById(id);
        return ResponseEntity.success();
    }

    @PostMapping("/doAssign")
    public ResponseEntity doAssign(String roleId,String[] permissionId) {
        permissionService.saveRolePermissionRealtionShipGuli(roleId,permissionId);
        return ResponseEntity.success();
    }

    @GetMapping("toAssign/{roleId}")
    public ResponseEntity toAssign(@PathVariable String roleId) {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return ResponseEntity.success().data("children", list);
    }



    @PostMapping("save")
    public ResponseEntity save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return ResponseEntity.success();
    }

    @PutMapping("update")
    public ResponseEntity updateById(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return ResponseEntity.success();
    }

}


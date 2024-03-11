package com.zhxm.spzx.manager.controller;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import com.zhxm.spzx.manager.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 角色添加的方法
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/saveSysRole")
    public Result savaSysRole(@RequestBody SysRole sysRole){
        sysRoleService.savaSysRole(sysRole);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    /**
     * 角色列表的方法
     * @param current
     * @param limit
     * @param sysRoleDto
     * @return
     */
    // current:当前页   limit：每页显示记录数
    // SysRoleDto: 条件角色名称对象
    @PostMapping("/findByPage/{current}/{limit}")
    public Result findByPage(@PathVariable("current") Integer current,
                             @PathVariable("limit") Integer limit,
                             @RequestBody SysRoleDto sysRoleDto){
        PageInfo<SysRole> pageInfo = sysRoleService.findByPage(sysRoleDto,current,limit);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }

    /**
     * 角色修改方法
     * @param sysRole
     * @return
     */
    @PutMapping(value = "/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.updateSysRole(sysRole) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 角色删除方法
     * @param roleId
     * @return
     */
    @DeleteMapping(value = "/deleteById/{roleId}")
    public Result deleteById(@PathVariable("roleId") Long roleId) {
        sysRoleService.deleteById(roleId) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

}

package com.zhxm.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageInfo;

public interface SysRoleService {

    // 角色列表的方法
    PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer current, Integer limit);

    //角色添加的方法
    void savaSysRole(SysRole sysRole);
}

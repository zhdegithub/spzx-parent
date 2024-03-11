package com.zhxm.spzx.manager.mapper;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    // 角色列表的方法
    List<SysRole> findByPage(SysRoleDto sysRoleDto);

    void save(SysRole sysRole);

    void updateSysRole(SysRole sysRole);
}

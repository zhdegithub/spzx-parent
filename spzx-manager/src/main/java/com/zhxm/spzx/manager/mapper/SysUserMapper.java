package com.zhxm.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    SysUser selectUserInfoByUserName(String username);
}

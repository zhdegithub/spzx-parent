package com.zhxm.spzx.manager.service;


import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.system.LoginVo;

public interface SysUserService {

    //用户登录
    LoginVo login(LoginDto loginDto);

    //获取当前登录信息
    SysUser getUserInfo(String token);

    //用户退出
    void logout(String token);
}

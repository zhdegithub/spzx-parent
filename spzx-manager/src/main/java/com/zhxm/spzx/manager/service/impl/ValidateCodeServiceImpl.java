package com.zhxm.spzx.manager.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.atguigu.spzx.model.vo.system.ValidateCodeVo;
import com.zhxm.spzx.manager.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {


    @Autowired
    private RedisTemplate<String ,String>redisTemplate;

    //生成图片验证码
    @Override
    public ValidateCodeVo generateValidateCode() {
        //1 通过工具生成图片验证码（hutool）
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150,48,4,2);
        String codeValue = circleCaptcha.getCode(); //4位验证码值
        String imageBase64 = circleCaptcha.getImageBase64();  //返回图片验证码，base64编码

        //2 把验证码存储的redis里面，设置redis的key：uuid  redis的value：验证码值 设置过期时间
        String codeKey = UUID.randomUUID().toString().replaceAll("-","");
        redisTemplate.opsForValue().set("user:login:validatecode:"+codeKey,codeValue,5, TimeUnit.MINUTES);

        //3 返回ValidateCodeVo对象
        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        validateCodeVo.setCodeKey(codeKey);
        validateCodeVo.setCodeValue("data:image/png;base64," + imageBase64);

        return validateCodeVo;
    }
}

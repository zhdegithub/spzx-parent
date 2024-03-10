package com.zhxm.spzx.common.exception;

import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class ZhException extends RuntimeException{
    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;
    public ZhException(ResultCodeEnum resultCodeEnum){
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }
}

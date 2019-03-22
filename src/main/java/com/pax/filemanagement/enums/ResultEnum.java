package com.pax.filemanagement.enums;

import lombok.Getter;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 23:04
 */
@Getter
public enum ResultEnum {
    USER_NOT_EXIST(10,"用户不存在"),
    PARAM_INPUT_ERROR(11,"参数传入错误"),
    PARAM_CORRECT(12,"参数传入正确"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.pax.filemanagement.VO;

import lombok.Data;

/**
 * @Author: Shawn
 * @Date: 2019/3/18 13:55
 * @Version 1.0
 */
@Data
public class ResultVO<T> {
    /**错误码. */
    private  Integer code;

    /**提示信息. */
    private String msg;

    /**具体信息. */
    private  T data;
}

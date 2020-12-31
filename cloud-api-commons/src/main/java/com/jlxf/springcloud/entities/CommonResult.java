package com.jlxf.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 11:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}

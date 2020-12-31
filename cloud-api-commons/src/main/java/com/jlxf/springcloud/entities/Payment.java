package com.jlxf.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 11:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable{

    private Long id;
    private String serial;


}

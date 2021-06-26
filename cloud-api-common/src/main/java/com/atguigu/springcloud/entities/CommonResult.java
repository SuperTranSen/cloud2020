package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author Transen
 * @version 1.0
 * @date 2021-04-01 19:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;


    CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}

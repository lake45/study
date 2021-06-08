package com.shop.system.common.message;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回前端传输数据
 * @author
 * @date
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnMessage {
    private int status;
    private Object data;
    private String msg;

}

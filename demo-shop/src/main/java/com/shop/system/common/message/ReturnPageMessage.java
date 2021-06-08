package com.shop.system.common.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回前端传输分页数据
 * @author Jay
 * @date
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnPageMessage {
    private int status;
    private Object data;
    private String msg;
    private Integer total;
}

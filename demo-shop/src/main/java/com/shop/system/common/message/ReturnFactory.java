package com.shop.system.common.message;


import com.shop.system.common.constant.ReturnCodeConsts;

/**
 * 返回前端传输数据的工厂类
 *
 * @author
 * @date
 */
public class ReturnFactory {

    /**
     * 分页接口请求成功
     * @param data
     * @return
     */
    public static ReturnPageMessage success(Object data, Integer total) {
        return new ReturnPageMessage(ReturnCodeConsts.SUCCESS_CODE, data, "ok", total);
    }

    /**
     * 分页接口请求失败
     * @param data
     * @return
     */
    public static ReturnPageMessage failPage(int code, String errMsg, Object... data) {
        return new ReturnPageMessage(code, data, "error:" + errMsg , 0);
    }

    /**
     * 接口请求成功
     * @param data
     * @return
     */
    public static ReturnMessage success(Object data) {
        return new ReturnMessage(ReturnCodeConsts.SUCCESS_CODE, data, "ok");
    }

    /**
     * 接口返回失败
     * @param errMsg
     * @return
     */
    public static ReturnMessage fail(int code,String errMsg) {
        return new ReturnMessage(code, "", errMsg);
    }

    /**
     * Object... obj
     * 接口返回失败，附带data
     * @param errMsg
     * @return
     */
    public static ReturnMessage fail(int code, String errMsg, Object... data) {
        return new ReturnMessage(code, data, errMsg);
    }
}

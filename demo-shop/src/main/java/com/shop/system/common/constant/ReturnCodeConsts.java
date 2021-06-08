package com.shop.system.common.constant;

/**
 * 返回码常量
 * @author
 * @date
 */
public class ReturnCodeConsts {

    /**
     * 请求成功
     */
    public static final Integer SUCCESS_CODE = 20;

    /**
     * 账号不存在
     */
    public static final Integer SUCCESS_CODE_NO = 10;



    /**
     * 登录错误码（账号或密码错误）
     */
    public static final Integer LOGIN_ERROR_CODE = 21;

    /**
     * 不允许操作
     */
    public static final Integer NOTALLOW_ERROR_CODE = 22;

    /**
     * 已重复
     */
    public static final Integer REPEAT_ERROR_CODE = 23;

    /**
     * 举报件编号重复
     */
    public static final Integer REPORTING_NUMBER_REPEAT_ERROR_CODE = 24;

    /**
     * 异常错误码
     */
    public static final Integer EXCEPTION_ERROR_CODE = 40;

    /**
     * 无权限错误码
     */
    public static final Integer NO_PERMISSION = 41;

    /**
     * 参数为空错误码
     */
    public static final Integer PARAM_IS_NULL_ERROR_CODE = 42;

    /**
     * 参数有误错误码
     */
    public static final Integer PARAM_IS_ERROR_CODE = 43;

    /**
     * 文件不存在
     */
    public static final  Integer FILE_NOT_FOUND = 44;

    /**
     * 更新失败
     */
    public static final Integer UPDATE_FAIL = 45;

    /**
     * 删除失败
     */
    public static final Integer DELET_FAIL = 46;


    /**
     * 存在数据引用
     */
    public static final Integer DATA_RELATION_ERROR = 47;

    /**
     * 版本号检查不一致异常
     */
    public static final Integer VERSION_CHECK_ERROR = 47;

    /**
     * 被举报职位职位级别 码表里的 只用于查核表
     */
    public static final String LEVEL_CODE = "BJBJB12380-1,BJBJB12380-2,BJBJB12380-3,BJBJB12380-4,BJBJB12380-5";


    /**
     * 存在数据引用
     */
    public static final String CANNOT_BE_DELETED = "已有数据绑定该选项，禁止删除";


    /**
     * 参数错误
     */
    public static final String PARAMETER_ERROR = "参数错误!";



}

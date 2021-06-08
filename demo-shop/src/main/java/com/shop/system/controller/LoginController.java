package com.shop.system.controller;

import com.alibaba.druid.util.StringUtils;
import com.shop.system.common.constant.ReturnCodeConsts;
import com.shop.system.domain.model.LoginModel;
import com.shop.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shop.system.common.message.ReturnFactory;
import com.shop.system.common.message.ReturnMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * 类作用：
 *
 * @author
 * @date
 */
@RestController
@RequestMapping("${process.apiPath}/system/")
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * 登录接口
     * @param userName
     * @param passWord
     * @return
     */
    @GetMapping("login")
    public ReturnMessage login(@RequestParam(required = true) String userName,
                               @RequestParam(required = true)String passWord){
        Map<String,Object> params = new HashMap<>(16);
        params.put("userName",userName);
        params.put("passWord",passWord);
        String ifExist = loginService.ifExist(params);
        if (!StringUtils.isEmpty(ifExist) && "0".equals(ifExist)){
            return ReturnFactory.fail(ReturnCodeConsts.SUCCESS_CODE_NO,"账号不存在！");
        }else {
            LoginModel loginModel = loginService.login(params);
            if (null == loginModel){
                return ReturnFactory.fail(ReturnCodeConsts.SUCCESS_CODE_NO,"密码错误！");
            }else {
                return ReturnFactory.success(loginModel);
            }
        }
    }

    /**
     * 注册
     */
    @GetMapping("register")
    public ReturnMessage register(@RequestParam(required = true) String userName,
                               @RequestParam(required = true)String passWord){
        Map<String,Object> params = new HashMap<>(16);
        params.put("userName",userName);
        params.put("passWord",passWord);
        String ifExist = loginService.ifExist(params);
        if (!StringUtils.isEmpty(ifExist) && "0".equals(ifExist)){
            LoginModel loginModel  = loginService.register(params);
            return ReturnFactory.success(loginModel);
        }else {
            return ReturnFactory.fail(ReturnCodeConsts.SUCCESS_CODE_NO,"账号已存在！");
        }
    }
}

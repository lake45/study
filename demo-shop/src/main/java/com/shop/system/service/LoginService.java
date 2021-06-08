package com.shop.system.service;

import com.shop.system.domain.model.LoginModel;

import java.util.Map;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:56 2021-03-18
 */

public interface LoginService {

    String ifExist(Map<String,Object> params);

    LoginModel login(Map<String, Object> params);

    LoginModel register(Map<String, Object> params);
}

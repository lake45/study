package com.shop.system.service.impl;

import com.shop.system.common.utils.Tools;
import com.shop.system.domain.mapper.LoginMapper;
import com.shop.system.domain.model.LoginModel;
import com.shop.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 10:16 2021-03-18
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired(required = false)
    private LoginMapper loginMapper;


    @Override
    public String ifExist(Map<String, Object> params) {
        return loginMapper.ifExist(params);
    }

    @Override
    public LoginModel login(Map<String, Object> params) {
        return loginMapper.login(params);
    }

    @Override
    public LoginModel register(Map<String, Object> params) {
        Tools.putParams(params);
        loginMapper.register(params);
        return loginMapper.login(params);
    }
}

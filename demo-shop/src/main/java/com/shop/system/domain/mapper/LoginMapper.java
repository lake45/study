package com.shop.system.domain.mapper;

import com.shop.system.domain.model.LoginModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 10:17 2021-03-18
 */
@Mapper
public interface LoginMapper {

    // 获取用户信息
    LoginModel getUserMessage(Map<String,Object> param);

    // 用户是否存在
    String ifExist(Map<String,Object> param);

    // 登录
    LoginModel login(Map<String,Object> param);

    // 注册存用户
    void register(Map<String,Object> param);
}

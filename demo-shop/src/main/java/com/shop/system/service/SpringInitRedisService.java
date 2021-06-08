package com.shop.system.service;

public interface SpringInitRedisService {

    /**
     * 项目启动加载系统参数到redis中
     */
    void findSystemParamToRedis();
}

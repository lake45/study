package com.shop.system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shop.system.common.constant.Constant;
import com.shop.system.domain.mapper.ShopCodeMapper;
import com.shop.system.domain.model.ShopCodeModel;
import com.shop.system.service.SpringInitRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SpringInitRedisServiceImpl implements SpringInitRedisService {


    @Autowired(required = false)
    private ShopCodeMapper shopCodeMapper;

    @Override
    public void findSystemParamToRedis() {

        storageShop();
    }

    /**
     * 获取码表保存到redis
     * @return
     */
    private boolean storageShop(){
        // 获取码表内容
        List<ShopCodeModel> areaModels = shopCodeMapper.findSysCodes();
        Map<String, String> map = new HashMap<>(16);
        //存进map
        for (int i = 0; i < areaModels.size(); i++) {
            map.put(areaModels.get(i).getCode(), String.valueOf(areaModels.get(i)));
        }
        Jedis redis = new Jedis("localhost");
        //存进redis
        redis.hmset(Constant.CODE,map);

        // 获取数据
        Map<String, String> stringStringMap = redis.hgetAll(Constant.CODE);

        String string = stringStringMap.get("shop-1");

//        JSONObject jsonObject = JSONObject.fromObject(json);

        return false;
    }

}

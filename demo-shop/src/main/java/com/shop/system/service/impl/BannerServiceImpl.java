package com.shop.system.service.impl;

import com.shop.system.domain.mapper.BannerMapper;
import com.shop.system.domain.model.BannerModel;
import com.shop.system.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类作用：
 *
 * @author Lake
 * @date 上午 11:29 2021-03-20
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired(required = false)
    BannerMapper bannerMapper;


    @Override
    public List<BannerModel> getBannerMessage() {
        return bannerMapper.getBannerMessage();
    }
}

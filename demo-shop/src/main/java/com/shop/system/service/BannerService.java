package com.shop.system.service;

import com.shop.system.domain.model.BannerModel;

import java.util.List;

/**
 * 类作用：
 *
 * @author Lake
 * @date 上午 11:29 2021-03-20
 */
public interface BannerService {

    List<BannerModel> getBannerMessage();
}

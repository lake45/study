package com.shop.system.domain.mapper;

import com.shop.system.domain.model.BannerModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类作用：
 *
 * @author Lake
 * @date 上午 11:32 2021-03-20
 */
@Mapper
public interface BannerMapper {

    List<BannerModel> getBannerMessage();
}

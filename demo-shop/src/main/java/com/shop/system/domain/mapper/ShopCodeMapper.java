package com.shop.system.domain.mapper;

import com.shop.system.domain.model.ShopCodeModel;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:49 2021-05-27
 */
@Mapper
public interface ShopCodeMapper extends BaseMapper<ShopCodeModel> {

    List<ShopCodeModel> findSysCodes();
}

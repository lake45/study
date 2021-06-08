package com.shop.base;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:23 2021-05-27
 */
@RegisterMapper
@Component
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>, MyIdsMapper<T>, SpecialBatchMapper<T>{
}

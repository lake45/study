package com.shop.base;

import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:25 2021-05-27
 */
@RegisterMapper
public interface MyIdsMapper<T> extends SelectByIdsMapper<T>, DeleteByIdsMapper<T> {
}

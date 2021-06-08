package com.shop.base;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:32 2021-05-27
 */
@RegisterMapper
public interface SpecialBatchMapper<T> {
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    @InsertProvider(
            type = SpecialBatchProvider.class,
            method = "insertListUseAllCols"
    )
    int insertListUseAllCols(List<T> recordList);
}

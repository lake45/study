package com.shop.system.service;


import com.shop.system.domain.model.BaseModel;

import java.util.List;

/**
 * Service基类
 * @author Jay
 * @date 2019-07-01 16:32
 */
public interface BaseService<T extends BaseModel> {


    /**
     * 保存
     * @param model
     * @return
     */
    T save(T model);

    /**
     * 更新
     * @param model
     */
    int update(T model);

    /**
     * 添加或更新(若ID为空则添加，否则更新)
     * @param model
     */
    void saveOrUpdate(T model);

    /**
     * 添加或更新(若ID为空则添加，否则更新) ，并返回model
     * @param model
     * @return
     */
    T saveOrUpdateReturnModel(T model);

    /**
     * 批量添加
     * @param modelList
     */
    void saveList(List<T> modelList);

    /**
     * 删除某一个Model(is_deleted设为true)
     * @param model
     */
    int delete(T model);




    /**
     * 根据ids字符串进行删除
     * @param ids
     * @throws Exception
     */
    void deleteByIds(String ids) throws Exception;

    /**
     * 通过ID查询Model
     * @param id
     * @return
     */
    T getModelById(String id);

    /**
     * 通过model查询Model
     * @param model
     * @return
     */
    T getModelByModel(T model);



    /**
     * 查询列表
     * @param t
     * @return
     */
    List<T> listModelsByParams(T t);

    /**
     * 获取当前时间
     * @return
     */
    String getCurrentTime();


    T saveWithoutAutoId(T t);

    void saveListWithoutAutoId(List<T> t);

    void saveWithCreateTime(T t);

    void batchInsert(List<T> insertList, int betchInt);
}

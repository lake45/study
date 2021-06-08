package com.shop.system.service.impl;

import com.shop.system.common.utils.GuidUtil;
import com.shop.base.MyMapper;
import com.shop.system.domain.model.BaseModel;
import com.shop.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    @Autowired(required = false)
    private MyMapper<T> mapper;

    /**
     * 保存
     * @param model
     */
    @Override
    public T save(T model){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.setCreateTime(simpleDateFormat.format(new Date()));
        model.setDeleted(false);
        model.setId(GuidUtil.getRandomId());
        mapper.insertSelective(model);
        return model;
    }

    /**
     * 更新
     * @param model
     */
    @Override
    public int update(T model){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.setUpdateTime(simpleDateFormat.format(new Date()));
        return mapper.updateByPrimaryKeySelective(model);
    }

    /**
     * 添加或更新(若ID为空则添加，否则更新)
     * @param model
     */
    @Override
    public void saveOrUpdate(T model){
        if(model.getId() == null || model.getId().equals("")){
            save(model);
            return;
        }
        update(model);
    }

    /**
     * 添加或更新(若ID为空则添加，否则更新) ，并返回model
     * @param model
     * @return
     */
    @Override
    public T saveOrUpdateReturnModel(T model){
        if(model.getId() == null){
            return save(model);
        }
        update(model);
        return model;
    }

    /**
     * 批量添加
     * @param modelList
     */
    @Override
    public void saveList(List<T> modelList){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Iterator iterator = modelList.iterator();
        while (iterator.hasNext()) {
            T model = (T) iterator.next();
            model.setCreateTime(simpleDateFormat.format(new Date()));
            model.setDeleted(false);
            model.setId(GuidUtil.getRandomId());
        }
        mapper.insertListUseAllCols(modelList);
    }

    /**
     * 删除某一个Model(is_deleted设为true)
     * @param model
     */
    @Override
    public int delete(T model){
        model.setDeleted(true);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.setUpdateTime(simpleDateFormat.format(new Date()));
        return update(model);
    }


    /**
     * 根据ids字符串进行删除
     * @param ids
     * @throws Exception
     */
    @Override
    public void deleteByIds(String ids) throws Exception{
        // 获取当前new的对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
        String[] idArray = ids.split(",");
        if(idArray.length > 0){
            for(String id : idArray){
                // 执行setId操作
                T t = clazz.newInstance();
                PropertyDescriptor idPropertyDescriptor = new PropertyDescriptor("id", clazz);
                Method idMethod = idPropertyDescriptor.getWriteMethod();
                idMethod.invoke(t, id);
                delete(t);
            }
        }
    }

    /**
     * 通过ID查询Model
     * @param id
     * @return
     */
    @Override
    public T getModelById(String id){
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 通过model查询Model
     * @param model
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T getModelByModel(T model){
        if(model.getDeleted() == null){
            model.setDeleted(false);
        }
        return mapper.selectOne(model);
    }

    /**
     * 查询列表
     * @param t
     * @return
     */
    @Override
    public List<T> listModelsByParams(T t){
        t.setDeleted(false);
        return mapper.select(t);
    }

    /**
     * 获取当前时间
     * @return
     */
    @Override
    public String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    @Override
    public T saveWithoutAutoId(T model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.setCreateTime(simpleDateFormat.format(new Date()));
        model.setDeleted(false);
        mapper.insertSelective(model);
        return model;
    }

    @Override
    public void saveListWithoutAutoId(List<T> modelList){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Iterator iterator = modelList.iterator();
        while (iterator.hasNext()) {
            T model = (T) iterator.next();
            model.setCreateTime(simpleDateFormat.format(new Date()));
            model.setDeleted(false);
        }
        mapper.insertListUseAllCols(modelList);
    }

    @Override
    public void saveWithCreateTime(T model) {
        model.setDeleted(false);
        model.setId(GuidUtil.getRandomId());
        mapper.insertSelective(model);
    }

    @Override
    public void batchInsert(List<T> insertList, int betchInt) {
        int i = 0;
        int insertLength = insertList.size();
        while (insertLength > betchInt) {
            mapper.insertListUseAllCols(insertList.subList(i, i + betchInt));
            i = i + betchInt;
            insertLength = insertLength - betchInt;
        }
        if (insertLength > 0) {
            mapper.insertListUseAllCols(insertList.subList(i, i + insertLength));
        }
    }
}

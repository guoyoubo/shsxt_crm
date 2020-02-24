package com.shsxt.base;

import org.springframework.dao.DataAccessException;

import java.util.List;

/*
*
*BaseDao  基本方法定义
* */
public interface BaseMapper<T,ID> {
    /**
     * 添加记录返回行数
     */
    public Integer insertSelective(T entity) throws DataAccessException;

    //添加记录返回主键
    public Integer insertHaskey(T entity)throws DataAccessException;

    /**
     * 批量添加
     */
    public Integer insertBatch(List<T> entities)throws DataAccessException;

    /**
     * 根据id查询详情
     */
    public T selectByPrimaryKey(ID id)throws DataAccessException;

    /**
     * 多条件查询
     */

   /* public List<T> selectByParams(BaseQuery baseQuery)throws DataAccessException;*/

    /**
     * 更新单挑记录
     */

    public Integer update(T entity)throws DataAccessException;

    /**
     * 更新多条记录
     * */
    public List<T> updateByPrimaryKeySelective(List<T> entities)throws DataAccessException;

    /**
     * 删除单挑记录
     * */
    public Integer deleteByPrimaryKey(ID id)throws DataAccessException;

    /**
    * 批量删除
    * */

    public Integer deleteBatch(ID[] ids)throws DataAccessException;
 }

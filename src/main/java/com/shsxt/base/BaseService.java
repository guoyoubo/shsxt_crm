package com.shsxt.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class BaseService<T ,ID> {

    @Autowired
    private BaseMapper <T ,ID>  baseMapper;
    /*
     *
     *BaseDao  基本方法定义
     * */


        /**
         * 添加记录返回行数
         */
        public Integer insertSelective(T entity) throws DataAccessException {
            return baseMapper.insertSelective(entity);
        }
        /**
         *  添加记录返回行数
         */
        public Integer insertHaskey(T entity) throws DataAccessException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
             baseMapper.insertHaskey(entity);
            return (Integer) entity.getClass().getMethod("getId").invoke(entity);
        }



        /**
         * 批量添加
         */
        public Integer insertBatch(List<T> entities)throws DataAccessException {
            return baseMapper.insertBatch(entities);
        }

        /**
         * 根据id查询详情
         */
        public T selectByPrimaryKey(ID id)throws DataAccessException {
            return  baseMapper.selectByPrimaryKey(id);
        }

        /**
         * 多条件查询
         */

        /*public List<T> selectByParams(BaseQuery baseQuery)throws DataAccessException {
            return baseMapper.selectByParams(baseQuery);
        }*/

        /**
         * 更新单挑记录
         */

        public Integer update(T entity)throws DataAccessException {
            return baseMapper.update(entity);
        }

        /**
         * 更新多条记录
         * */
        public List<T> updateByPrimaryKeySelective(List<T> entities)throws DataAccessException {
            return baseMapper.updateByPrimaryKeySelective(entities);
        }

        /**
         * 删除单挑记录
         * */
        public Integer deleteByPrimaryKey(ID id)throws DataAccessException {
            return baseMapper.deleteByPrimaryKey(id);

        }

        /**
         * 批量删除
         * */

        public Integer deleteBatch(ID[] ids)throws DataAccessException {
            return baseMapper.deleteBatch(ids);
        }

}

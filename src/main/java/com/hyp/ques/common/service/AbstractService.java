package com.hyp.ques.common.service;


import com.hyp.ques.common.Mapper;
import com.hyp.ques.common.result.ResultCode;
import com.hyp.ques.utils.LogicUtil;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 *
 * @author hyp
 */
public abstract class AbstractService<T> implements Service<T> {


    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        try {
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            modelClass = (Class<T>) pt.getActualTypeArguments()[0];
        } catch (Exception e) {
            throw new ServiceException("AbstractService中的modelClass实例化错误",
                    ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public int save(T model) {
        if (null != model) {
            return mapper.insertSelective(model);
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public int save(List<T> models) {
        if (null != models) {

            return mapper.insertList(models);

        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public int deleteById(Long id) {
        if (null != id) {
            if (null == mapper.selectByPrimaryKey(id)) {
                throw new ServiceException("不存在这样的对象", ResultCode.FAIL);
            }
            return mapper.deleteByPrimaryKey(id);
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public int deleteByIds(String ids) {
        if (null != ids) {
            if (null == mapper.selectByIds(ids)) {
                throw new ServiceException("不存在这样的对象", ResultCode.FAIL);
            }
            return mapper.deleteByIds(ids);
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public int update(T model) {
        if (null != model) {
            if (null != mapper.selectOne(model)) {
                return mapper.updateByPrimaryKeySelective(model);
            }
            throw new ServiceException("不存在这样的对象", ResultCode.FAIL);
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public T findById(Long id) {
        if (null != id) {
            return mapper.selectByPrimaryKey(id);
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        if (null != fieldName && !"".equals(fieldName) && null != value) {
            try {
                T model = modelClass.newInstance();
                Field field = modelClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(model, value);
                return mapper.selectOne(model);
            } catch (ReflectiveOperationException e) {
                throw new ServiceException(e.getMessage(), e, ResultCode.INTERNAL_SERVER_ERROR);
            }
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public List<T> findByIds(String ids) {
        if (null != ids) {
            return mapper.selectByIds(ids);
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        if (null != condition) {
            return mapper.selectByCondition(condition);
        }
        throw new ServiceException("存在空值", ResultCode.FAIL);
    }


    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public int count(Map<String, Object> map) {
        Example example = new Example(modelClass);
        Example.Criteria criteria = example.createCriteria();
        if (LogicUtil.isNotNullAndEmpty(map)) {
            for (String s : map.keySet()) {
                criteria.andEqualTo(s, map.get(s));
            }
        }
        return mapper.selectCountByCondition(example);
    }
}

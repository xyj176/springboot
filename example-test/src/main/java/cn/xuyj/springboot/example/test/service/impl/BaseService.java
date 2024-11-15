package cn.xuyj.springboot.example.test.service.impl;

import cn.xuyj.springboot.example.test.mapper.SequenceMapper;
import cn.xuyj.springboot.example.test.service.IService;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 13:27
 */

public abstract class BaseService<T> implements IService<T> {
    @Autowired
    protected Mapper<T> mapper;

    @Autowired
    SequenceMapper sequenceMapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    public Long getSequence(@Param("seqName") String seqName) {
        return sequenceMapper.getSequence(seqName);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entity) {
        return mapper.insert(entity);
    }

    @Override
    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int update(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
}

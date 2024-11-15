package cn.xuyj.springboot.example.test.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 13:21
 */
public interface IService<T> {
    /**
     * 获取下一序列值
     *
     * @param seqName
     * @return
     */
    Long getSequence(@Param("seqName") String seqName);

    /**
     * 查所有数据
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 根据主键进行查询
     *
     * @param key
     * @return
     */
    T selectByKey(Object key);

    /**
     * 保存实体
     *
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 根据主键进行删除
     * @param key
     * @return
     */
    int delete(Object key);

    /**
     * 更新实体，null值也会被更新
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 更新实体，null值不被更新
     * @param entity
     * @return
     */
    int updateNotNull(T entity);

    /**
     * 根据Example条件进行查询。
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);
}

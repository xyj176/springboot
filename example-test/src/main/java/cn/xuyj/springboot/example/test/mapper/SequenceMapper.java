package cn.xuyj.springboot.example.test.mapper;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 11:17
 */
public interface SequenceMapper {
    @Select("select nextval('${seqName}')")
    Long getSequence(String seqName);
}

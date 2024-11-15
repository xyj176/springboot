package cn.xuyj.springboot.example.test.config;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author xuyj
 * @des 自定义MyMapper接口，一定要加@RegisterMapper注解
 * @since 2024/11/15 13:20
 */
@RegisterMapper
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

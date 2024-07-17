package cn.xuyj.springboot.example.service;

import cn.xuyj.springboot.example.bean.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author xuyj
 * @since 2024/7/17 15:30
 */
@CacheConfig(cacheNames = "student")
public interface StudentService {

    @CachePut(key = "#p0.id")
    Student update(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    void delete(String id);

    @Cacheable(key = "#p0")
    Student query(String id);
}

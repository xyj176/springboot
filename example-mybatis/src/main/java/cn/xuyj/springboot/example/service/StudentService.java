package cn.xuyj.springboot.example.service;

import cn.xuyj.springboot.example.entity.Student;

/**
 * @author xuyj
 * @since 2024/7/15 14:55
 */
public interface StudentService {

    int add(Student student);

    int update(Student student);

    int delete(String id);

    Student queryById(String id);
}

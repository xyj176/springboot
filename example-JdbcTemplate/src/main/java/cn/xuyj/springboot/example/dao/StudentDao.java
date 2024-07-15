package cn.xuyj.springboot.example.dao;

import cn.xuyj.springboot.example.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author xuyj
 * @since 2024/7/15 17:00
 */
public interface StudentDao {
    int add(Student student);

    int update(Student student);

    int delete(String id);

    Student queryById(String id);

    List<Map<String, Object>> queryStudents();
}

package cn.xuyj.springboot.example.service;

import cn.xuyj.springboot.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xuyj
 * @since 2024/7/15 17:22
 */

public interface StudentService {
    int add(Student student);

    int update(Student student);

    int delete(String id);

    Student queryById(String id);

    List<Map<String, Object>> queryStudents();
}

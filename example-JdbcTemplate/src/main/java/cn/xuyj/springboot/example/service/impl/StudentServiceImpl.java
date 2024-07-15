package cn.xuyj.springboot.example.service.impl;

import cn.xuyj.springboot.example.dao.StudentDao;
import cn.xuyj.springboot.example.entity.Student;
import cn.xuyj.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xuyj
 * @since 2024/7/15 17:23
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao dao;

    @Override
    public int add(Student student) {
        return dao.add(student);
    }

    @Override
    public int update(Student student) {
        return dao.update(student);
    }

    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Student queryById(String id) {
        return dao.queryById(id);
    }

    @Override
    public List<Map<String, Object>> queryStudents() {
        return dao.queryStudents();
    }
}

package cn.xuyj.springboot.example.service.impl;

import cn.xuyj.springboot.example.entity.Student;
import cn.xuyj.springboot.example.mapper.StudentMapper;
import cn.xuyj.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuyj
 * @since 2024/7/15 14:56
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper mapper;

    @Override
    public int add(Student student) {
        return mapper.add(student);
    }

    @Override
    public int update(Student student) {
        return mapper.update(student);
    }

    @Override
    public int delete(String id) {
        return mapper.deleteById(id);
    }

    @Override
    public Student queryById(String id) {
        return mapper.queryById(id);
    }
}

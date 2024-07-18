package cn.xuyj.springboot.example.service.Impl;

import cn.xuyj.springboot.example.bean.Student;
import cn.xuyj.springboot.example.mapper.StudentMapper;
import cn.xuyj.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuyj
 * @since 2024/7/17 15:39
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper mapper;

    @Override
    public Student update(Student student) {
        mapper.update(student);
        return query(student.getId());
    }

    @Override
    public void delete(String id) {
        mapper.delete(id);
    }

    @Override
    public Student query(String id) {
        return mapper.query(id);
    }
}

package cn.xuyj.springboot.example.controller;

import cn.xuyj.springboot.example.entity.Student;
import cn.xuyj.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuyj
 * @since 2024/7/15 14:59
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/add")
    public int add(Student student) {
        return service.add(student);
    }

    @PostMapping("/update")
    public int update(Student student) {
        return service.update(student);
    }

    @GetMapping("/query")
    public Student query(String id) {
        return service.queryById(id);
    }

    @DeleteMapping("/delete")
    public int delete(String id) {
        return service.delete(id);
    }
}

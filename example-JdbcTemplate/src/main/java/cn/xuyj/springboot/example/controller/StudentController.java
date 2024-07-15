package cn.xuyj.springboot.example.controller;

import cn.xuyj.springboot.example.entity.Student;
import cn.xuyj.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xuyj
 * @since 2024/7/15 17:24
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/query/{id}")
    public Student query(@PathVariable String id) {
        return service.queryById(id);
    }

    @GetMapping("/query")
    public List<Map<String, Object>> query() {
        return service.queryStudents();
    }

    @PostMapping("/add")
    public int add(Student student) {
        return service.add(student);
    }

    @DeleteMapping("/delete")
    public int delete(String id) {
        return service.delete(id);
    }
}

package cn.xuyj.springboot.example.exception.controller;

import cn.xuyj.springboot.example.exception.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/26 15:12
 */
@RestController
public class HelloController {
    @Autowired
    HelloService service;

    @GetMapping("/{id}")
    public void get(@PathVariable String id) {
        service.hello(id);
    }
}

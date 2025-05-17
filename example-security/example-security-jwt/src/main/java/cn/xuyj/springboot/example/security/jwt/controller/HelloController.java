package cn.xuyj.springboot.example.security.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 13:40
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security with jwt";
    }
}

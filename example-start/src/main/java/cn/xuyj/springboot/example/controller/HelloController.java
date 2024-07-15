package cn.xuyj.springboot.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @since 2024/7/15 10:03
 */
@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "hello world!";
    }
}

package cn.xuyj.springboot.example.war.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/26 14:26
 */
@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "hello world!";
    }
}

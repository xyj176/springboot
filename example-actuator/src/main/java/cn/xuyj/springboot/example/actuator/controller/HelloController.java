package cn.xuyj.springboot.example.actuator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/25 10:07
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello() {
        return "hello world!";
    }
}

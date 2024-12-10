package cn.xuyj.springboot.example.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/10 10:38
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //正则表达式
    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        System.out.println("参数id:" + id);
    }
}

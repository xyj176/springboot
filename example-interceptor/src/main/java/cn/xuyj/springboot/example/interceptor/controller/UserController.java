package cn.xuyj.springboot.example.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/10 11:26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //正则表达式
    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        System.out.println("参数id:" + id);
        //可以观察注释掉异常前后控制台的输出
        throw new RuntimeException("user not exist");
    }
}

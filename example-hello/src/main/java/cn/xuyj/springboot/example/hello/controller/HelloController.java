package cn.xuyj.springboot.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/27 10:32
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public void hello() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println("hello world!");
    }
}

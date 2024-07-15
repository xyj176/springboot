package cn.xuyj.springboot.example.controller;

import cn.xuyj.springboot.example.Bean.BlogProperties;
import cn.xuyj.springboot.example.Bean.BlogProperties2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @since 2024/7/15 10:42
 */
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private BlogProperties2 blogProperties2;

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/blog/v1")
    public String blog() {
        return blogProperties.getName() + "--" + blogProperties.getTitle();
    }

    @GetMapping("/blog/v2")
    public String blog2() {
        return blogProperties2.getName() + "--" + blogProperties2.getTitle();
    }
}

package cn.xuyj.springboot.example.controller;

import cn.xuyj.springboot.example.Bean.BlogConfigBean;
import cn.xuyj.springboot.example.Bean.BlogConfigBean2;
import cn.xuyj.springboot.example.Bean.TestConfigBean;
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
    private BlogConfigBean blogConfigBean;

    @Autowired
    private BlogConfigBean2 blogConfigBean2;

    @Autowired
    private TestConfigBean testConfigBean;

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/blog/v1")
    public String blog() {
        return blogConfigBean.getName() + "--" + blogConfigBean.getTitle();
    }

    @GetMapping("/blog/v2")
    public String blog2() {
        return blogConfigBean2.getName() + "--" + blogConfigBean2.getTitle();
    }

    @GetMapping("/test")
    public String test() {
        return testConfigBean.getName() + "-" + testConfigBean.getAge();
    }
}

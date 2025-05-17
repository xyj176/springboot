package cn.xuyj.springboot.example.security.defaultconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 11:45
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@RestController
public class HelloController {
    //引入Spring Security依赖的时候，项目会默认开启认证。
    // 访问http://localhost:8080/hello，可看到页面弹出了个HTTP Basic认证框
    // 默认用户名是user，密码会自动输出到控制台
    @GetMapping("/hello")
    public String hello() {
        return "hello security with default config!";
    }
}

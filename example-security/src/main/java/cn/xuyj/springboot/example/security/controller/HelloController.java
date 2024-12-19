package cn.xuyj.springboot.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/19 15:59
 */
@RestController
public class HelloController {
    //引入Spring Security依赖的时候，项目会默认开启认证。
    // 访问http://localhost:8080/hello，可看到页面弹出了个HTTP Basic认证框
    // 默认用户名是user，密码会自动输出到控制台
    @GetMapping("/hello")
    public String hello() {
        return "hello spring security!";
    }
}

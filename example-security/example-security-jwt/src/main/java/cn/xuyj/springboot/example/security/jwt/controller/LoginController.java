package cn.xuyj.springboot.example.security.jwt.controller;

import cn.xuyj.springboot.example.security.jwt.domain.LoginRequest;
import cn.xuyj.springboot.example.security.jwt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:14
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService service;
    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request,HttpServletResponse response) {
        String token = service.login(request);
        response.addHeader("Authorization","Bearer "+token);
        return true;
    }
}

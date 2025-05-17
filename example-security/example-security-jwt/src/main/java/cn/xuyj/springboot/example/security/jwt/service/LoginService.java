package cn.xuyj.springboot.example.security.jwt.service;

import cn.xuyj.springboot.example.security.jwt.domain.LoginRequest;
import cn.xuyj.springboot.example.security.jwt.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:18
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@Slf4j
@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginRequest request) {
        // 创建未认证的令牌
        //这里的用户名和密码会和UserDetailsService.loadUserByUsername()中的用户名密码进行匹配
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
        // 触发认证
        // 自动完成以下步骤：
        // 1. 调用UserDetailsService.loadUserByUsername()
        // 2. 用PasswordEncoder验证密码是否匹配
        authenticationManager.authenticate(
                authenticationToken
        );
        //生成token
        String token = jwtUtil.generateToken(request.getUsername());
        log.info("登录成功");
        return token;
    }
}

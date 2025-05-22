package cn.xuyj.springboot.example.security.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:10
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@SpringBootApplication(scanBasePackages = {"cn.xuyj.springboot.example.*"})
public class SecurityJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }
}

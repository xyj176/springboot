package cn.xuyj.springboot.example.security.jwt.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:17
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@Data
public class LoginRequest implements Serializable {
    private String username;
    private String password;
}

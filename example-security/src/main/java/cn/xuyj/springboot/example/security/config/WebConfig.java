package cn.xuyj.springboot.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/19 16:48
 */
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
    //密码加密接口
    @Bean
    public PasswordEncoder passwordEncoder() {
        //BCryptPasswordEncoder可以对相同的密码进行加密后可以生成不同的结果
        return new BCryptPasswordEncoder();
    }
}

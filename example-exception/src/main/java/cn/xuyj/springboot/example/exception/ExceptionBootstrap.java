package cn.xuyj.springboot.example.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/26 15:11
 */
@SpringBootApplication
public class ExceptionBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ExceptionBootstrap.class, args);
    }
}

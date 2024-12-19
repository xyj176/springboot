package cn.xuyj.springboot.example.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/19 13:22
 */
@SpringBootApplication
@EnableAsync
public class AsyncBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AsyncBootstrap.class, args);
    }
}

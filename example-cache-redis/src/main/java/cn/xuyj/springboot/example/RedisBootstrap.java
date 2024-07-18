package cn.xuyj.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author xuyj
 * @since 2024/7/18 9:49
 */
@SpringBootApplication
@EnableCaching
public class RedisBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(RedisBootstrap.class, args);
    }
}

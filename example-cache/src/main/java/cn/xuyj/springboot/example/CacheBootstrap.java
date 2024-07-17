package cn.xuyj.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author xuyj
 * @since 2024/7/17 15:12
 */
@SpringBootApplication
@EnableCaching
public class CacheBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CacheBootstrap.class, args);
    }
}

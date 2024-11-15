package cn.xuyj.springboot.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 11:07
 */
@SpringBootApplication
@MapperScan("cn.xuyj.springboot.example.test.mapper")
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}

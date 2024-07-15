package cn.xuyj.springboot.example.Bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xuyj
 * @since 2024/7/15 13:11
 */
@Data
@Configuration
//指定读取的配置文件
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "test")
public class TestConfigBean {
    private String name;
    private String age;
}

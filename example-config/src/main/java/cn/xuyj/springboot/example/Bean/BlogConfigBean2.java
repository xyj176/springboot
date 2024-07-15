package cn.xuyj.springboot.example.Bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyj
 * @since 2024/7/15 11:10
 */
@Configuration
//读取指定前缀的配置
@ConfigurationProperties(prefix = "mrbird.blog")
@Data
public class BlogConfigBean2 {
    private String name;
    private String title;
}

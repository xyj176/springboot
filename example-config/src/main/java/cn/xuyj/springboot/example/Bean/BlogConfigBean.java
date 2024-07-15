package cn.xuyj.springboot.example.Bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xuyj
 * @since 2024/7/15 10:46
 */
@Component
@Data
public class BlogConfigBean {
    @Value("${mrbird.blog.name}")
    private String name;
    @Value("${mrbird.blog.title}")
    private String title;
}

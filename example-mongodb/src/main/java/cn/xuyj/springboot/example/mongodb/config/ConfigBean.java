package cn.xuyj.springboot.example.mongodb.config;

import cn.xuyj.springboot.example.mongodb.util.PathUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/8 16:40
 */
@Configuration
@Data
public class ConfigBean {
    private static final String HOME = System.getProperty("user.dir");

    public static final String TEM_DIR = PathUtil.combine(HOME, "tmp");

    @Value("${spring.data.mongodb.buckets}")
    private String buckets;
}

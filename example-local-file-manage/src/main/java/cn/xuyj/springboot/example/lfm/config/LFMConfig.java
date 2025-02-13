package cn.xuyj.springboot.example.lfm.config;

import cn.xuyj.springboot.example.lfm.util.XFileUtil;
import cn.xuyj.springboot.example.lfm.util.XPathUtil;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author xuyj
 * @des 本地文件管理模块的配置类
 * @since 2025/2/13 9:49
 */
@Configuration
@Data
public class LFMConfig {
    private static final String HOME = System.getProperty("user.dir");

    public static final String LOCAL_DATA_LIBRARY = XPathUtil.combine(HOME, "LOCAL_DATA_LIBRARY");

    public static final String TMP = XPathUtil.combine(LOCAL_DATA_LIBRARY, "tmp");

    public static final String UPLOAD = XPathUtil.combine(LOCAL_DATA_LIBRARY, "upload");

    @PostConstruct
    public void init() {
        XFileUtil.mkdir(LOCAL_DATA_LIBRARY);
        XFileUtil.mkdir(TMP);
        XFileUtil.mkdir(UPLOAD);
    }
}

package cn.xuyj.springboot.example.mongodb.util;

import cn.hutool.core.io.FileUtil;
import cn.xuyj.springboot.example.mongodb.config.ConfigBean;

import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/8 17:27
 */
public class PathUtil {
    public static String combine(String firstPath, String... otherPaths) {
        return null != otherPaths && 0 != otherPaths.length ? Paths.get(firstPath, otherPaths).toString() : firstPath;
    }

    public static String createTmpDir() {
        String tmp = combine(ConfigBean.TEM_DIR, UUID.randomUUID().toString());
        FileUtil.mkdir(tmp);
        return tmp;
    }
}

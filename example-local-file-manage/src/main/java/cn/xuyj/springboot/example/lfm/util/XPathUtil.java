package cn.xuyj.springboot.example.lfm.util;

import cn.hutool.core.io.file.PathUtil;
import cn.xuyj.springboot.example.lfm.config.LFMConfig;

import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/13 9:56
 */
public class XPathUtil extends PathUtil {
    /**
     * 合并路径
     *
     * @param first
     * @param others
     * @return
     */
    public static String combine(String first, String... others) {
        return others != null && others.length > 0 ? Paths.get(first, others).toString() : first;
    }

    /**
     * 创建临时文件夹
     *
     * @return
     */
    public static String createTmpDir() {
        String tmpDir = XPathUtil.combine(LFMConfig.TMP, UUID.randomUUID().toString());
        XFileUtil.mkdir(tmpDir);
        return tmpDir;
    }
}

package cn.xuyj.springboot.example.infrastructure.util;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/13 14:53
 */
public class ExceptionUtil {
    /**
     * 获取异常的详细错误信息
     *
     * @param e
     * @return
     */
    public static String getMessage(Exception e) {
        e.printStackTrace();
        String message = e + " at " + e.getStackTrace()[0];
        return message;
    }
}

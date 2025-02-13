package cn.xuyj.springboot.example.ftp.service;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/10 14:53
 */
public interface FtpService {
    Boolean upload(String path);

    String download(String fileName);
}

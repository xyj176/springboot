package cn.xuyj.springboot.example.ftp.service;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/10 14:53
 */
public interface FtpService {
    /**
     * 上传文件，同名文件会被覆盖
     *
     * @param path：本地文件路径
     * @return true表示上传成功，false表示上传失败
     */
    Boolean upload(String path);

    /**
     * 文件下载
     *
     * @param fileName：远程文件名
     * @return 返回本地保存的文件路径
     */
    String download(String fileName);

    /**
     * 判断文件是否存在
     *
     * @param fileName
     * @return
     */
    Boolean exist(String fileName);
}

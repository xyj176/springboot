package cn.xuyj.springboot.example.ftp.config;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/10 14:48
 */
@Configuration
@Data
@Slf4j
public class FtpConfig {
    @Value("${ftp.host}")
    private String host;

    @Value("${ftp.port}")
    private Integer port;

    @Value("${ftp.username}")
    private String userName;

    @Value("${ftp.password}")
    private String password;

    @Value("${ftp.path}")
    private String path;

    public FTPClient connect() {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        ftpClient.setConnectTimeout(10000);
        try {
            ftpClient.connect(host, port);
            //判断是否连接成功
            if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                //用户名和密码不为空，则进行登录认证
                if (StrUtil.isNotEmpty(userName) && StrUtil.isNotEmpty(password)) {
                    if (!ftpClient.login(userName, password)) {
                        log.error("ftp服务器连接成功，但用户认证失败：" +
                                "用户名【" + userName + "】或密码【" + password + "】错误");
                        disConnect(ftpClient);
                        return null;
                    }
                }
                log.info("ftp连接成功！");
                //文件传输的方式
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //被动模式：调用FTPClient.enterLocalPassiveMode();这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
                ftpClient.enterLocalPassiveMode();
                return ftpClient;
            } else {
                log.error("ftp服务器连接失败！");
                disConnect(ftpClient);
                return null;
            }
        } catch (Exception e) {
            log.error("FTP连接失败：" + e.getMessage());
            return null;
        }
    }

    public void disConnect(FTPClient ftpClient) {
        try {
            if (ftpClient != null && ftpClient.isConnected()){
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception e) {
            log.error("与ftp服务器断开链接失败：" + e.getMessage());
        }
    }
}

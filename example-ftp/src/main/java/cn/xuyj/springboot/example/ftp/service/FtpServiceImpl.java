package cn.xuyj.springboot.example.ftp.service;

import cn.hutool.core.io.FileUtil;
import cn.xuyj.springboot.example.ftp.config.FtpConfig;
import cn.xuyj.springboot.example.lfm.util.XPathUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/10 14:53
 */
@Service
@Slf4j
public class FtpServiceImpl implements FtpService {
    @Autowired
    FtpConfig ftpConfig;

    @Override
    public Boolean upload(String path) {
        FTPClient ftpClient = ftpConfig.connect();
        if (ftpClient == null || !ftpClient.isAvailable())
            return false;
        try {
            InputStream inputStream = new FileInputStream(path);
            //storeFile方法的第一个参数表示保存到远程ftp服务器上的文件的名称
            return ftpClient.storeFile(FileUtil.getName(path), inputStream);
        } catch (Exception e) {
            log.error("文件上传失败：" + e.getMessage());
            return false;
        } finally {
            ftpConfig.disConnect(ftpClient);
        }
    }

    @Override
    public String download(String fileName) {
        FTPClient ftpClient = ftpConfig.connect();
        String localFilePath = XPathUtil.combine(XPathUtil.createTmpDir(), fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(localFilePath);
            boolean retrieve = ftpClient.retrieveFile(fileName, fos);
            if (!retrieve)
                localFilePath = null;
            return localFilePath;
        } catch (Exception e) {
            log.error("从ftp服务器下载数据失败：" + e.getMessage());
            return null;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    log.error("关闭文件流失败：" + e.getMessage());
                }
            }
            ftpConfig.disConnect(ftpClient);
        }
    }
}

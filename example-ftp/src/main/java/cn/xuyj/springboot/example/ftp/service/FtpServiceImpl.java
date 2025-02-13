package cn.xuyj.springboot.example.ftp.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.xuyj.springboot.example.ftp.config.FtpConfig;
import cn.xuyj.springboot.example.infrastructure.util.ExceptionUtil;
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
        try {
            InputStream inputStream = new FileInputStream(path);
            //storeFile方法的第一个参数表示保存到远程ftp服务器上的文件的名称
            return ftpClient.storeFile(FileUtil.getName(path), inputStream);
        } catch (Exception e) {
            log.error("文件上传失败：" + ExceptionUtil.getMessage(e));
            return false;
        } finally {
            ftpConfig.disConnect(ftpClient);
        }
    }

    @Override
    public String download(String fileName) {
        FTPClient ftpClient = ftpConfig.connect();
        String localFilePath = null;
        InputStream ins = null;
        FileOutputStream fos = null;
        try {
            ins = ftpClient.retrieveFileStream(fileName);
            if (ins != null) {
                localFilePath = XPathUtil.combine(XPathUtil.createTmpDir(), fileName);
                fos = new FileOutputStream(localFilePath);
                byte[] buffer = new byte[1024];
                int read;
                while ((read = ins.read(buffer)) != -1) {
                    fos.write(buffer, 0, read);
                }
            }
        } catch (Exception e) {
            localFilePath = null;
            log.error("从ftp服务器下载数据失败：" + ExceptionUtil.getMessage(e));
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    log.error("关闭文件流失败：" + ExceptionUtil.getMessage(e));
                }
            }
            if (ins != null) {
                try {
                    ins.close();
                } catch (Exception e) {
                    log.error("文件流关闭失败：" + ExceptionUtil.getMessage(e));
                }
            }
            ftpConfig.disConnect(ftpClient);
        }
        if (StrUtil.isEmpty(localFilePath))
            throw new RuntimeException("文件下载失败！");
        return localFilePath;
    }
}

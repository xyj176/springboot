package cn.xuyj.springboot.example.ftp;

import cn.xuyj.springboot.example.ftp.service.FtpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/13 9:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FtpTest {

    @Autowired
    private FtpService service;

    @Test
    public void testUpload() {
        String localPath = "D:\\data\\选址报告模板.docx";
        Boolean upload = service.upload(localPath);
        System.out.println(upload);
    }
}

package cn.xuyj.springboot.example.ftp.controller;

import cn.xuyj.springboot.example.ftp.service.FtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/13 15:25
 */
@RestController
public class FtpController {
    @Autowired
    private FtpService service;

    @GetMapping("/download")
    public String download(String fileName) {
        return service.download(fileName);
    }

    @GetMapping("/exist")
    public Boolean exist(String fileName) {
        return service.exist(fileName);
    }
}

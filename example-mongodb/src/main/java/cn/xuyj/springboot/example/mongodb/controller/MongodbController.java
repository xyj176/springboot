package cn.xuyj.springboot.example.mongodb.controller;

import cn.xuyj.springboot.example.mongodb.service.MongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: xuyj
 * @Date: 2025/2/8 19:13
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@RestController
public class MongodbController {
    @Autowired
    private MongodbService service;

    @GetMapping("/download/id")
    public String downloadById(String id) {
        String download = service.downloadById(id, "");
        return download;
    }

    @GetMapping("/download/name")
    public String downloadByName(String name) {
        String download = service.downloadByName(name, "");
        return download;
    }
}

package cn.xuyj.springboot.example.kafka.controller;

import cn.xuyj.springboot.example.kafka.domain.Message;
import cn.xuyj.springboot.example.kafka.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/20 15:36
 */
@RestController
public class SendMessageController {
    @Autowired
    SendMessageService service;

    @GetMapping("/send")
    public void send(String message) {
        service.send(message);
    }

    @PostMapping("/send")
    public void send(@RequestBody Message message) {
        service.send(message);
    }
}

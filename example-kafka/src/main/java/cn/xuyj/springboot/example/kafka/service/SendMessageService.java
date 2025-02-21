package cn.xuyj.springboot.example.kafka.service;

import cn.xuyj.springboot.example.kafka.domain.Message;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/20 15:36
 */
public interface SendMessageService {
    void send(String message);

    void send(Message message);
}

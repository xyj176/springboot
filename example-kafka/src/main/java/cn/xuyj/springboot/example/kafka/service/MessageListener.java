package cn.xuyj.springboot.example.kafka.service;

import cn.xuyj.springboot.example.kafka.domain.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/20 16:03
 */
@Component
@Slf4j
public class MessageListener {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "test", groupId = "test-consumer", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        Message o = null;
        try {
            o = objectMapper.readValue(message, Message.class);
            log.info("接收Message对象信息：{}", message);
        } catch (JsonProcessingException e) {
            log.error("尝试解析为Message对象失败！" + e);
            log.info("接收String消息：{}", message);
        }
    }
}

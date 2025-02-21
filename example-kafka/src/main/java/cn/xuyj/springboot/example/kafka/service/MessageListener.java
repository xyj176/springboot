package cn.xuyj.springboot.example.kafka.service;

import cn.xuyj.springboot.example.kafka.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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

    @KafkaListener(topics = "test", groupId = "test-consumer",containerFactory = "kafkaListenerContainerFactory")
    public void listen(Object message) {
        if (message instanceof ConsumerRecord) {
            Object value = ((ConsumerRecord) message).value();
            if (value instanceof String)
                log.info("接收String消息：{}", value);
            if (value instanceof Message) {
                log.info("接收Message消息：{}", value);
            }
        }
    }
}

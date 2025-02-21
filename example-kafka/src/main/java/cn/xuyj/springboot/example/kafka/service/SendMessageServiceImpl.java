package cn.xuyj.springboot.example.kafka.service;

import cn.xuyj.springboot.example.kafka.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/20 15:37
 */
@Service
@Slf4j
public class SendMessageServiceImpl implements SendMessageService {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(String message) {
        ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send("test", message);
        send.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("消息【{}】发送失败，原因：{}", message, ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("消息【{}】发送成功！offset = [{}]", message, result.getRecordMetadata().offset());
            }
        });
    }

    @Override
    public void send(Message message) {

        ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send("test", message);
        send.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("消息【{}】发送失败,，原因：{}", message.toString(), ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("消息【{}】发送成功！offset = [{}]", message.toString(), result.getRecordMetadata().offset());
            }
        });
    }
}

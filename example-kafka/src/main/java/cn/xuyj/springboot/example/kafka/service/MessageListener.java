package cn.xuyj.springboot.example.kafka.service;

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
    @KafkaListener(topics = "test")
    public void listen(String message) {
        log.info("接收到消息：{}", message);
    }

//    //获取消息来自哪个分区
//    @KafkaListener(topics = "test")
//    public void listen(@Payload String message,
//                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        log.info("接收到消息：{}，partition：{}", message, partition);
//    }
//
//    //指定接收特定分区的消息
//    //如果不需要指定initialOffset，代码可以简化为：
//    // @KafkaListener(groupId = "test-consumer",topicPartitions = @TopicPartition(topic = "test", partitions = { "0", "1" }))
//    @KafkaListener(groupId = "test-consumer",
//            topicPartitions = @TopicPartition(topic = "test",
//                    partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0")}))
//    public void listenWithPartition(@Payload String message,
//                                    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        log.info("接收消息: {}，partition：{}", message, partition);
//    }
}

package cn.xuyj.springboot.example.kafka.config;

import cn.xuyj.springboot.example.kafka.domain.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/20 15:45
 */
@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Autowired
    ConsumerFactory<String,Object> consumerFactory;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        //过滤策略
        //出现"fuck"字眼则不接收
        factory.setRecordFilterStrategy(new RecordFilterStrategy<String, Object>() {
            @Override
            public boolean filter(ConsumerRecord<String, Object> consumerRecord) {
                Object value = consumerRecord.value();
                if (value instanceof String){
                    return ((String) value).contains("fuck");
                }else if (value instanceof Message){
                    return ((Message) value).getInfo().contains("fuck");
                }
                return false;
            }
        });
        return factory;
    }
}

package com.kafka.kafkastreaming.stream.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class MessageDetailConsumer {

    @Bean
    Consumer<Message<String>> consumeMessageDetail() {
        return detail -> {
            log.info("Consuming message detail from processor: {}", detail);
        };
    }
}

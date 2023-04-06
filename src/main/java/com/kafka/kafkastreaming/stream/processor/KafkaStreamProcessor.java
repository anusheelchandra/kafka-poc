package com.kafka.kafkastreaming.stream.processor;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Slf4j
@Configuration
public class KafkaStreamProcessor {

    @Timed
    @Counted
    @Bean
    public Function<Flux<Message<String>>, Flux<Message<String>>> processMessageDetail() {
        return inbound -> inbound.map(this::doProcess)
                .distinct()
                .log();
    }

    private Message<String> doProcess(Message<String> message) {
        String detail = message.getPayload();
        return message;
    }
}

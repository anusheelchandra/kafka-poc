package com.kafka.kafkastreaming.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaStreamBridge {

    private final StreamBridge streamBridge;

    public <T> boolean submit(String binding, T data) {
        return streamBridge.send(binding, wrapAvroPayload(data));
    }

    public static <T> Message<T> wrapAvroPayload(T data) {
        return MessageBuilder.withPayload(data)
                .setHeader("contentType", "application/*+avro")
                .build();
    }
}

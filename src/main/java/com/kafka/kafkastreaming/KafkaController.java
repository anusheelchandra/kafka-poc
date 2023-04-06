package com.kafka.kafkastreaming;

import com.kafka.kafkastreaming.service.KafkaStreamBridge;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class KafkaController {

    private final KafkaStreamBridge service;

    @Timed
    @Counted
    @PostMapping(value = "/message")
    public ResponseEntity<String> postMessage(@RequestBody String message) {
        var isSuccess = service.submit("message-detail-out-0", message);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(isSuccess ? "Success" : "Error");
    }

}

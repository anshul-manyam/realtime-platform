package com.realtime.processing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DlqProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String DLQ_TOPIC = "events-dlq";

    public void sendToDlq(Object event, Exception ex) {
        System.out.println("Sending to DLQ: "+ event);
        kafkaTemplate.send(DLQ_TOPIC, event);
    }
}

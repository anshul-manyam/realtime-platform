package com.realtime.api_service.service;

import com.realtime.api_service.model.Event;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, Event> kafkaTemplate;

    private static final String TOPIC = "events-topic-v2";

    public void sendEvent(Event event) {
        kafkaTemplate.send(TOPIC, event.getEventId(), event);
    }
}

package com.realtime.processing.service;

import com.realtime.processing.entity.EventEntity;
import com.realtime.processing.model.Event;
import com.realtime.processing.repository.EventRepository;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventConsumer {

    private static final Logger log = LoggerFactory.getLogger(EventConsumer.class);

    private final EventRepository eventRepository;

    private final MeterRegistry meterRegistry;

    @KafkaListener(topics = "events-topic-v2", containerFactory = "kafkaListenerContainerFactory", groupId = "event-processing-group-v2")
    @Transactional
    public void consume(Event event) {

        // Metric
        meterRegistry.counter("kafka.events.received").increment();

        log.info("Received event: {}", event);

        try {
            if (event.getAmount() > 300) {
                throw new RuntimeException("Invalid amount");
            }

            // Metric
            meterRegistry.counter("kafka.events.processed").increment();

            log.info("Processed event successfully: {}", event);

        } catch (Exception e) {

            // Metric
            meterRegistry.counter("kafka.events.failed").increment();

            log.error("Failed processing event: {}", event, e);
            throw e;
        }
    }
}

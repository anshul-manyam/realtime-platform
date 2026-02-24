package com.realtime.api_service.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Event {

    private String eventId = UUID.randomUUID().toString();
    private Double amount;
    private String type;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();
}

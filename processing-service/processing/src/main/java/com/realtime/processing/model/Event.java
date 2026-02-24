package com.realtime.processing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    private String eventId;
    private String type;
    private Double amount;
    private String status;
    private LocalDateTime createdAt;
}

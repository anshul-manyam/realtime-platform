package com.realtime.processing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
public class EventEntity {

    @Id
    @Column(name = "event_id")
    private String eventId;

    private String type;
    private Double amount;
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

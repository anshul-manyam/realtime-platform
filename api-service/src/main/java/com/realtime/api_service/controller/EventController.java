package com.realtime.api_service.controller;

import com.realtime.api_service.model.Event;
import com.realtime.api_service.service.EventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventProducer eventProducer;

    @PostMapping
    public String createEvent(@RequestBody Event event){
        eventProducer.sendEvent(event);
        return "Event sent successfully!";
    }
}

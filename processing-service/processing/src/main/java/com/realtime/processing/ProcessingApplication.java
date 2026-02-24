package com.realtime.processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@SpringBootApplication
public class ProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessingApplication.class, args);
	}

}

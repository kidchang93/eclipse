package com.ckhub.kafkademo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ckhub.kafkademo.payload.Student;
import com.ckhub.kafkademo.producer.KafkaJsonProducer;
import com.ckhub.kafkademo.producer.KafkaProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

	private final KafkaProducer kafkaProducer;
	private final KafkaJsonProducer kafkaJsonProducer;
	
	@PostMapping
	public ResponseEntity<String> sendMessages(@RequestBody String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message queued successfully");
	}
	
	@PostMapping("/json")
	public ResponseEntity<String> sendJsonMessages(@RequestBody Student message){
		kafkaJsonProducer.sendMessage(message);
		return ResponseEntity.ok("Message queued successfully as JSON");
	}
}

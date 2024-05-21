package com.ckhub.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ckhub.kafkademo.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	/*
	 * @KafkaListener(topics = "ckhub", groupId = "myGroup") public void
	 * consumeMsg(String msg) {
	 * 
	 * log.info("Consuming the message from ckhub Topic :: " + msg);
	 * 
	 * }
	 */
	
	@KafkaListener(topics = "ckhub", groupId = "myGroup")
	public void consumeJsonMsg(Student student) {
		
		log.info("Consuming the message from ckhub Topic :: " + student.toString());
		
	}
}

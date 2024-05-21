package com.ckhub.kafkademo.producer;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	// private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
	public void sendMessage(String msg) {
		
		// LOGGER.info(String.format("Sending message to ckhub Topic :: %s", msg));
		log.info(String.format("Sending message to ckhub Topic :: %s", msg));
		kafkaTemplate.send("ckhub",msg);
		
	}
}

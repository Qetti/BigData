package com.example.quiz_example_3;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
	
	@KafkaListener(
			topics = "quiz3", 
			groupId = "groupId"
			)
	void listener(String data) {
		System.out.println("Listener received: " + data);
	}
}

package com.example.quiz_example_3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class QuizExample3Application {

	public static void main(String[] args) {
		SpringApplication.run(QuizExample3Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("quiz3", "Qetti");
		};
	}

}

package com.vardhan.programming.producer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
	
	@Bean
	public Supplier<String> source() {
		return () -> {
			System.out.println("\n Calling source.....");
			return "tweet #" + ThreadLocalRandom.current().nextInt();
		};
	}

}

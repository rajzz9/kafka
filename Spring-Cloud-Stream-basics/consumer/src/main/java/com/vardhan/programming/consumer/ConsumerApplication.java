package com.vardhan.programming.consumer;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	
	@Bean
	public Function<String, String> processor(){
		return s -> s.toUpperCase();
	}
	
	
	@Bean
	public Consumer<String> sink() {
		return System.out::println;
	}
}

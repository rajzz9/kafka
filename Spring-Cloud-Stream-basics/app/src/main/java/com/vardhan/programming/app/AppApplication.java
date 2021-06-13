package com.vardhan.programming.app;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Autowired
	private StreamBridge streamBridge;
	
	@PostMapping
	public void delegateToSink(@RequestBody String body) {
		streamBridge.send("sink-in-0", body);
	}
	
	@Bean
	public Consumer<String> sink(){
		return (data) -> System.out.println("----------sink---------- " + data);
	}
}

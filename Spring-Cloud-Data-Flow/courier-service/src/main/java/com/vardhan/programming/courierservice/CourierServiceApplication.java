package com.vardhan.programming.courierservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CourierServiceApplication {

	Logger logger = LoggerFactory.getLogger(CourierServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CourierServiceApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void orderDispatched(List<Product> products) {
		products.forEach(product -> {
			logger.info("Order dispatched to your mailing address : " + product);
		});
	}

}

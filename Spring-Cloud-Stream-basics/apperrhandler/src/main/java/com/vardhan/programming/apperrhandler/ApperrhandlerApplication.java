package com.vardhan.programming.apperrhandler;

import java.util.Random;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@SpringBootApplication
public class ApperrhandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApperrhandlerApplication.class, args);
	}

	
	@Bean
	public Consumer<String> numberSink(){
		return (String data) -> {
			System.out.println("number sink " + Integer.parseInt(data));
		};
	}
	Random r = new Random();
	@Bean
	public Consumer<String> devideSink(){
		return (String data) -> {
			int intValue = r.nextInt(Integer.MAX_VALUE);
			System.out.println("devide sink " + intValue/Integer.parseInt(data));
		};
	}
	
	//1. Individual channel error handler: <topic-name>.<group-name>.errors
	
	/*@ServiceActivator(inputChannel="numberSink-in-0.numberSinkGroup.errors")
	public void errFromNumberSink(Message<?> m) {
		System.out.println("err from number sink "+ m);
	}
	
	@ServiceActivator(inputChannel="devideSink-in-0.devideSinkGroup.errors")
	public void errFromDevideSink(Message<?> m) {
		System.out.println("err from devide sink "+ m);
	}*/
	
	//2. Global error handler: errorChannel
	
	@ServiceActivator(inputChannel="errorChannel")
	public void globalErrorhandler(Message<?> errMsg) {
		System.out.println("Global error handler "+ errMsg);
	}
}

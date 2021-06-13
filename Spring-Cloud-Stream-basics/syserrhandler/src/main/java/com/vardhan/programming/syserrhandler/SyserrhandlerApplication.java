package com.vardhan.programming.syserrhandler;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SyserrhandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyserrhandlerApplication.class, args);
	}

	int retryCount = 1;
	
	@Bean
	public Consumer<String> numberSink(){
		return (String data) -> {
			//if(retryCount == 1000) {
				//throw new AmqpRejectAndDontRequeueException("exception....");
			//}
				
			System.out.println(retryCount + " attemp to deliver data "+ data);
			System.out.println("Data from topic: " + Integer.parseInt(data));
			retryCount = 1;
		};
	}
	
	//@RabbitListener(queues="numberSink-in-0.numberSinkGroup.dlq")
	//public void dlqMessage(Message<?> message) {
		//System.err.println("message from dlq "+ message);
	//}
}

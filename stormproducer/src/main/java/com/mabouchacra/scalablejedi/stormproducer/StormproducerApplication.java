package com.mabouchacra.scalablejedi.stormproducer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class StormproducerApplication {

	public static final String JEDI_QUEUE = "jedi-queue";

	@Bean
	Queue queue() {
		return new Queue(JEDI_QUEUE, true);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(JEDI_QUEUE);
	}

	public static void main(String[] args) {
		SpringApplication.run(StormproducerApplication.class, args);
	}
}

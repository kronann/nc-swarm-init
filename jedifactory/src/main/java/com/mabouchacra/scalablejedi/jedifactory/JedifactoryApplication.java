package com.mabouchacra.scalablejedi.jedifactory;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.AbstractConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class JedifactoryApplication {

	@Bean
	public SimpleRabbitListenerContainerFactory myRabbitListenerContainerFactory(
			AbstractConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory);
		containerFactory.setRecoveryInterval(Long.valueOf(10000));

		return containerFactory;
	}

	public static void main(String[] args) {
		SpringApplication.run(JedifactoryApplication.class, args);
	}
}

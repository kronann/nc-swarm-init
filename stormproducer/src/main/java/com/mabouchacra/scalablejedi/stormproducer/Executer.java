package com.mabouchacra.scalablejedi.stormproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by marc on 19/04/17.
 */
@Component
public class Executer {

	public static AtomicInteger count = new AtomicInteger(1);

	private RabbitTemplate template;

 	public Executer(RabbitTemplate template) {
		this.template = template;
	}

	@Scheduled(fixedRate = 2000)
	public void attack() {		 
		template.convertAndSend("jedi-queue", "Attack!!! Stormtrooper!! N°:" + count.getAndIncrement());
	}
}

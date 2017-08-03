package com.mabouchacra.scalablejedi.stormproducer;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.mabouchacra.scalablejedi.stormproducer.StormproducerApplication.JEDI_QUEUE;

/**
 * Created by marc on 19/04/17.
 */
@Component
public class Executer {

	public static AtomicInteger count = new AtomicInteger(1);

	private RabbitAdmin admin;

	private RabbitTemplate template;

	@Autowired
	public Executer(RabbitTemplate template) {
		this.template = template;
		this.admin = new RabbitAdmin(this.template.getConnectionFactory());
		createQueue();
	}

	void createQueue() {
		admin.declareQueue(new Queue(JEDI_QUEUE));
	}

	@Scheduled(fixedRate = 500, initialDelay = 5000)
	public void attack() {
		template.convertAndSend( JEDI_QUEUE, "Attack!!! Stormtrooper!! N°:" + count.getAndIncrement());
	}
}

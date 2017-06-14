package com.mabouchacra.scalablejedi.stormproducer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
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

    @Scheduled(fixedRate = 2000)
    public void attack(){
        ConnectionFactory connectionFactory = new CachingConnectionFactory();
        AmqpTemplate template = new RabbitTemplate(connectionFactory);
        System.out.println("Sending...");
        template.convertAndSend("jedi-queue", "Attack!!! Stormtrooper!! N°:"+ count.getAndIncrement());
    }
}

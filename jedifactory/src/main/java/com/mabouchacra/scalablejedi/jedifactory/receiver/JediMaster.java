package com.mabouchacra.scalablejedi.jedifactory.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by marc on 19/04/17.
 */
@Component
public class JediMaster {

    private static CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = {"jedi-queue"}, containerFactory = "myRabbitListenerContainerFactory")
    public void defend(String message) throws InterruptedException {
        System.out.println("Message received : " + message);
        //Thread.currentThread().wait(3000);
    }
}

package com.mabouchacra.scalablejedi.stormproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class StormproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StormproducerApplication.class, args);
	}
}

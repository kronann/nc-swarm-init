package com.mabouchacra.scalablejedi.jedifactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JedifactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JedifactoryApplication.class, args);
	}
}

package com.github.fabriciolfj.clientretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class ClientRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRetryApplication.class, args);
	}

}

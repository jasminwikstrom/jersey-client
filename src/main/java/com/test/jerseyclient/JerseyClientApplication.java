package com.test.jerseyclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class JerseyClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseyClientApplication.class, args);
	}
}

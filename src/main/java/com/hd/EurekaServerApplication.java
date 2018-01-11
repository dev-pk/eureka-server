package com.hd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
/**
 * Eureka server spring boot application class
 * 
 * @author pxk3659
 *
 */
public class EurekaServerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}

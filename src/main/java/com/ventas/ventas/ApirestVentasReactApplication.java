package com.ventas.ventas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApirestVentasReactApplication {
	private static final Logger logger = LoggerFactory.getLogger(ApirestVentasReactApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(ApirestVentasReactApplication.class, args);
	}

}

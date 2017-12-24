package com.gts.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gts.web.models.Bus;

@SpringBootApplication
public class GtsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtsWebApplication.class, args);
		Bus bus = new Bus();
		bus.setIsOk(true);
		}
}

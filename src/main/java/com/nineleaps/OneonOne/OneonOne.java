package com.nineleaps.OneonOne;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.Controller","com.Services"})
@EnableJpaRepositories("com.DataRepositories")
public class OneonOne {

	public static void main(String[] args) {
		SpringApplication.run(OneonOne.class, args);
	}

}

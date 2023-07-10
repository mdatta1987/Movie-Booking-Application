package com.upgrad.movieapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
public class MovieappApplication {

	public static void main(String[] args) {


		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}


}

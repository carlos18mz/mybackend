package com.nttdata.mybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class MybackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybackendApplication.class, args);
	}

}

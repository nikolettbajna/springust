package com.qa.springust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringustApplication {

	public static void main(String[] args) {
		ApplicationContext beanbag = SpringApplication.run(SpringustApplication.class, args);
	}

}

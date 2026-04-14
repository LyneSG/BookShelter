package com.sguichard.library.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.sguichard.library.book.model")
@EnableJpaRepositories(basePackages = "com.sguichard.library.book.persistence")
@SpringBootApplication(scanBasePackages = {
		"com.sguichard.library"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
package com.kkini.kkiniadminbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KkiniAdminBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KkiniAdminBackendApplication.class, args);
	}

}

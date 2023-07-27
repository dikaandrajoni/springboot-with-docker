package com.dika.crud_provinsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudProvinsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProvinsiApplication.class, args);
	}

}

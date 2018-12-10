package com.clarkamurray.pbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class PbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbsApplication.class, args);
	}

}

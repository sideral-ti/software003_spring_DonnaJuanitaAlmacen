package com.sideralti.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Software000Application {

	public static void main(String[] args) {
		SpringApplication.run(Software000Application.class, args);
	}

	@GetMapping
	public String index() {
		return "index";
	}

}

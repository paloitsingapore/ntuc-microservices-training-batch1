package com.ntuc.income.BootifulApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootifulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootifulApplication.class, args);
	}

	@PostMapping("/sayhello")
	public String greet(@RequestBody String name){
		return "Hello " + name + " !";
	}

}

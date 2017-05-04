package com.greenfox;

import com.greenfox.colors.RedColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellobeanworldApplication implements CommandLineRunner {
	@Autowired
	HelloWorld hw;
	@Autowired
	RedColor rc;

	public static void main(String[] args) {
		SpringApplication.run(HellobeanworldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		hw.setMessage("Hello World!");
		hw.getMessage();
		rc.printColor();
	}
}

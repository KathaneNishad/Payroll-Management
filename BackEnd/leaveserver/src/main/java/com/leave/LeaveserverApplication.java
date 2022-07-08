package com.leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeaveserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveserverApplication.class, args);
		System.out.println("Leave working fine...");
	}

}

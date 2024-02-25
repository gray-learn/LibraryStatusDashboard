package com.gray.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LibraryStatusDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryStatusDashboardApplication.class, args);
	}

}

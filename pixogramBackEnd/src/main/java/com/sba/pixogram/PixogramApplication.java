package com.sba.pixogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PixogramApplication {

	public static void main(String[] args) {   
		SpringApplication.run(PixogramApplication.class, args);
	}

}
     
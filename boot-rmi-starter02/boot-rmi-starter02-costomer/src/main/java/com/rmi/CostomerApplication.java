package com.rmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anno.RemoteClientScan;

@SpringBootApplication
@RemoteClientScan(value = "com.rmi.api",url = "localhost:1234")
public class CostomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CostomerApplication.class, args);
	}
}

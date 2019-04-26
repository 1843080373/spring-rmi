package com.rmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anno.RemoteClientScan;

@SpringBootApplication
@RemoteClientScan(value = "com.rmi.api",url = "127.0.0.1:1234")
public class CostomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CostomerApplication.class, args);
	} 
}

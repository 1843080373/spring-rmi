package com.boot.client.controller;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rmi.vo.UserVO;
import com.boot.rmi.ws.HelloRemoteService;
import com.boot.rmi.ws.OrderRemoteService;
import com.boot.rmi.ws.UserRemoteService;

@RestController
public class HelloController {

	@Autowired
	private HelloRemoteService helloRemoteService;
	
	@Autowired
	private OrderRemoteService orderRemoteService;
	
	@Autowired
	private UserRemoteService userRemoteService;
	
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		try {
			return helloRemoteService.say(name) + "," + orderRemoteService.order(name);
		} catch (RemoteException e) {
			try {
				throw new RemoteException(e.getMessage());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	@GetMapping("/user")
	public ResponseEntity<String> user() {
		UserVO user =new UserVO()
				.setPassword("1")
				.setPhone("2")
				.setUserName("3");
		userRemoteService.save(user);
		return ResponseEntity.ok("请求成功!");
	}
}

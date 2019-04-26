package com.rmi.ws;

import org.springframework.stereotype.Service;

import com.rmi.anno.RemoteService;
import com.rmi.anno.RmiServiceProperty;
import com.rmi.api.HelloRemoteService;

@RemoteService(serviceInterface=HelloRemoteService.class)
@RmiServiceProperty(registryPort = 1234)
@Service
public class HelloWSService implements HelloRemoteService {
	@Override
	public String say(String name) {
		return "hello "+name;
	}

}

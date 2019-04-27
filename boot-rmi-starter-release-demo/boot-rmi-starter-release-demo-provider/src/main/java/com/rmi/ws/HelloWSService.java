package com.rmi.ws;

import com.rmi.anno.RemoteService;
import com.rmi.api.HelloRemoteService;

@RemoteService
public class HelloWSService implements HelloRemoteService {
	
	public String say(String name) {
		return "hello "+name;
	}

}

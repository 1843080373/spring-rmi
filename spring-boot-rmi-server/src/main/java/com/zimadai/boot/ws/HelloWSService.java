package com.zimadai.boot.ws;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.boot.rmi.ws.HelloRemoteService;

@Service
public class HelloWSService implements HelloRemoteService {
	@Override
	public String say(String name) throws RemoteException {
		return "hello "+name;
	}

}

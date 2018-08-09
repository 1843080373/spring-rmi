package com.zimadai.boot.ws;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.boot.rmi.ws.OrderRemoteService;
@Service
public class OrderWSService implements OrderRemoteService {

	@Override
	public String order(String name)  throws RemoteException{
		return "order "+name;
	}

}

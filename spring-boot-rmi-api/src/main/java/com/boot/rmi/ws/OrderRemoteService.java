package com.boot.rmi.ws;

import java.rmi.RemoteException;

public interface OrderRemoteService {
	
	public String order(String name) throws RemoteException;
}

package com.boot.rmi.ws;

import java.rmi.RemoteException;

public interface HelloRemoteService {

	public String say(String name) throws RemoteException;
}

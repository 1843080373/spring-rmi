package com.rmi.api;

import com.anno.RemoteClient;

@RemoteClient
public interface HelloRemoteService {

	public String say(String name);
}

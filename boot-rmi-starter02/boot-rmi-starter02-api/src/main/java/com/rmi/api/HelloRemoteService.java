package com.rmi.api;

import com.core.anno.RemoteClient;

@RemoteClient
public interface HelloRemoteService {
	public String say(String name);
}

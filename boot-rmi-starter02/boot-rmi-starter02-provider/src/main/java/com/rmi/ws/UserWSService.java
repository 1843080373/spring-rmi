package com.rmi.ws;

import org.springframework.stereotype.Service;

import com.rmi.anno.RemoteService;
import com.rmi.anno.RmiServiceProperty;
import com.rmi.api.UserRemoteService;
import com.rmi.vo.UserVO;

@RemoteService(serviceInterface=UserRemoteService.class)
@RmiServiceProperty(registryPort = 1234)
@Service
public class UserWSService implements UserRemoteService {

	@Override
	public UserVO save(UserVO user) {
		user.setUserId(1);
		return user;
	}
	
}

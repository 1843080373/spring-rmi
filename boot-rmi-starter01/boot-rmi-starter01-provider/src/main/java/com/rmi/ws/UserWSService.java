package com.rmi.ws;

import com.rmi.anno.RemoteService;
import com.rmi.api.UserRemoteService;
import com.rmi.vo.UserVO;

@RemoteService
public class UserWSService implements UserRemoteService {

	public UserVO save(UserVO user) {
		user.setUserId(1);
		return user;
	}
	
}

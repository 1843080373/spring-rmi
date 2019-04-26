package com.rmi.api;

import com.anno.RemoteClient;
import com.rmi.vo.UserVO;
@RemoteClient
public interface UserRemoteService {
	public UserVO save(UserVO user);
}

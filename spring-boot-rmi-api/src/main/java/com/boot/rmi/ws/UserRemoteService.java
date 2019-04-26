package com.boot.rmi.ws;

import java.util.List;

import com.boot.rmi.vo.UserVO;

public interface UserRemoteService {

	public UserVO save(UserVO user);
	
	public List<UserVO> list();
}

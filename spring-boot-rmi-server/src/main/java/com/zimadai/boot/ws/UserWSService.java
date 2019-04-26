package com.zimadai.boot.ws;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boot.rmi.vo.UserVO;
import com.boot.rmi.ws.UserRemoteService;
import com.zimadai.boot.bean.User;
import com.zimadai.boot.mapper.UserMapper;

/**
 * @author Administrator
 *
 */
@Service
public class UserWSService implements UserRemoteService {

	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional
	public UserVO save(UserVO user) {
		User userLocal = new User();
		BeanUtils.copyProperties(user, userLocal);
		userMapper.insert(userLocal);
		UserVO UserVO = new UserVO();
		BeanUtils.copyProperties(userLocal, UserVO);
		return UserVO;
	}

	@Override
	public List<UserVO> list() {
		return userMapper.list();
	}
}

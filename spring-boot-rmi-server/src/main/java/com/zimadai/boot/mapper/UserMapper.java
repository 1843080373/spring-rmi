package com.zimadai.boot.mapper;

import java.util.List;

import com.boot.rmi.vo.UserVO;
import com.zimadai.boot.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAllUser();

	List<UserVO> list();
}
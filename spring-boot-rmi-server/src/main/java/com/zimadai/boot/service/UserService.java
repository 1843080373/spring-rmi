package com.zimadai.boot.service;

import java.util.List;

import com.zimadai.boot.bean.User;

public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}

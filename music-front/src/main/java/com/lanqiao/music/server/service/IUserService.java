package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    void deleteUserById(Integer id);

    void updateUserByPrimaryKeySelective(User user);

    void saveUserSelective(User user);

    User getUserById(Integer id);

}

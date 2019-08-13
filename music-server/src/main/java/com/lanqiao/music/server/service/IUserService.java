package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.User;

import java.util.List;

import com.lanqiao.music.server.pojo.User;

public interface IUserService {

    List<User> getAll();
    User login(String uname, String upwd);

}

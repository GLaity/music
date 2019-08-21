package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.User;

import java.util.List;


public interface IUserService {
    Integer login(String uname, String upwd);

    List<User> getAllUser();
}

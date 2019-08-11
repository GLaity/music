package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.User;

public interface IUserService {
    User login(String uname, String upwd);
    User findUserByUid(Integer uid);
    void modifyUser(User user);
}

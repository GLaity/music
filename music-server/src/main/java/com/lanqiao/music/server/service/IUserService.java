package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.User;

public interface IUserService {
    Integer login(String uname, String upwd);
    User findUserByUid(Integer uid);
}

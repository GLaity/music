package com.lanqiao.music.server.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    Integer login(String uname, String upwd);

    List<User> getAll();
}

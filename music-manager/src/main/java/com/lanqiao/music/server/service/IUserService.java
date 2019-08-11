package com.lanqiao.music.server.service;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    Integer login(String uname, String upwd);
}

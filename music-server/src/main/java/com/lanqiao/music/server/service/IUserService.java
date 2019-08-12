package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.User;

public interface IUserService {
    User login(String uname, String upwd);
    User findUserByUid(Integer uid);
    void modifyUser(User user);
    //充值消费money
    void addBalance(User user,Double money);
    void reduceBalance(User user,Double money);
    //充值会员
    void rechargeVip(User user,Integer mouth);

}

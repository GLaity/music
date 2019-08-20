package com.lanqiao.music.server.frontservice;

import com.lanqiao.music.server.pojo.User;

public interface IUserService {
    User login(String uname, String upwd);
    void register(User user);
    User findUserByUid(Integer uid);
    void modifyUser(User user);
    User findUserByName(String uname);
    //充值消费money
    void addBalance(User user,Double money);
    void reduceBalance(User user,Double money);
    //充值会员
    void rechargeVip(User user,Integer mouth);
    //选择用户创建歌单
    User getCreateSheet(Integer uid);

}

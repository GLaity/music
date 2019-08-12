package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.UserMapper;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String uname, String upwd) {
        User user = userMapper.selectUserByUname(uname);
        if (user == null){
            return null;
        } else {
            if (user.getUpwd().equals(upwd)){
                return user;
            } else {
                return null;
            }
        }
    }

    @Override
    public User findUserByUid(Integer uid) {
        return userMapper.selectUserByUid(uid);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.updateUser(user);
    }
//      if (user.getUpwd().equals(upwd)){
//
//        //登陆成功
//        Date nowDate = new Date();
//        if(user.getVdate()!=null){
//            if(nowDate.getTime()<user.getVdate().getTime()){
//
//                return 2;//会员身份
//            }else {
//                userMapper.updateUserVipByUId(user.getUid());
//
//                return 0;//普通用户
//            }
//        }else {
//            return 0;
//        }
//    } else {
//        return 1;
//    }

}

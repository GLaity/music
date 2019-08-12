package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.UserMapper;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
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
                //登陆成功
                Date nowDate = new Date();
                int flag=0;
                if(user.getVdate()!=null){
                    if(nowDate.getTime()<user.getVdate().getTime()){
                        user.setIsvip(true);//会员身份
                    }else {
                        userMapper.updateUserVipByUId(user.getUid());
                        user.setIsvip(false);//普通用户
                    }
                }else {
                    user.setIsvip(false);//普通用户
                }
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




    //充值消费
    @Override
    public void addBalance(User user,Double money) {
        user.setUbalance(user.getUbalance()+money);
        userMapper.updateUser(user);
    }

    @Override
    public void reduceBalance(User user,Double money) {
        user.setUbalance(user.getUbalance()-money);
        userMapper.updateUser(user);
    }
    //充值会员
    @Override
    public void rechargeVip(User user, Integer mouth) {
        Date d;
        if(user.getVdate()==null){
            d = new Date();
        }else{
            d = user.getVdate();
        }
        Calendar cd = Calendar.getInstance();
        cd.setTime(d);
        cd.add(Calendar.DAY_OF_MONTH,+mouth);
        user.setVdate(cd.getTime());
        userMapper.updateUser(user);
    }

}

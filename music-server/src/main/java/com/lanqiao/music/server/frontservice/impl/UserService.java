package com.lanqiao.music.server.frontservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.UserMapper;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.frontservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


@Component
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ISheetService iSheetService;

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
    public void register(User user) {
        userMapper.insertUser(user);
        iSheetService.addInitSheet(user.getUid());
    }

    @Override
    public User findUserByUid(Integer uid) {
        return userMapper.selectUserByUid(uid);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User findUserByName(String uname) {
        User user = userMapper.selectUserByUname(uname);
        return user;
    }


    //充值金额
    @Override
    public void addBalance(User user,Double money) {
//        Double d = user.getUbalance()+money;
//        user.setUbalance(d);
        user.setUbalance((user.getUbalance()+money));
        userMapper.updateUser(user);
    }
    //减少余额
    @Override
    public void reduceBalance(User user,Double money) {
        user.setUbalance((user.getUbalance()-money));
        userMapper.updateUser(user);
    }
    //充值会员
    @Override
    public void rechargeVip(User user, Integer mouth) {
//        if(user.getVdate()!=null){
////            user.setVdate(subMonth(user.getVdate(),mouth));
////        }else {
////            user.setVdate(subMonth(new Date(),mouth));
////        }
////        user.setUbalance((user.getUbalance()-(mouth*10.0)));
        userMapper.updateUser(user);
    }
//获取自建歌单和收藏歌单 type=12
    @Override
    public User getCreateSheet(Integer uid) {
        User user = userMapper.selectUserByUid(uid);
        Set<Sheet> sheetSet = userMapper.selectCollectionSheet(uid);
        sheetSet.addAll(userMapper.selectCreateSheet(uid));
        user.setUCollectionSheet(sheetSet);
        return user;
    }



    //增加一个月
    public  Date subMonth(Date date,Integer mouth){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, mouth);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        Date d = null;
        try {
            d = sdf.parse(reStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}

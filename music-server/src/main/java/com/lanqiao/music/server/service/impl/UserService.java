package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.UserMapper;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        List<User> users =userMapper.selectAll();
        return users;
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUserByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void saveUserSelective(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User getUserById(Integer id) {

        return userMapper.selectByPrimaryKey(id);
    }


}

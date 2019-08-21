package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    Integer insertUser(User user);
    void updateUser(User user);
    User selectUserByUname(String uname);
    User selectUserByUid(Integer uid);
    List<User> selectAllUser();
}

package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User selectUserByUname(String uname);
}

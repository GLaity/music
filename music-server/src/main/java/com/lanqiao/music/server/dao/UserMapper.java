package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface UserMapper {
    User selectUserByUname(String uname);
    //会员到期清空会员数据
    void updateUserVipByUId(Integer uid);
}

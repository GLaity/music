package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Mapper
public interface UserMapper {
    Integer insertUser(User user);
    void updateUser(User user);
    User selectUserByUname(String uname);
    User selectUserByUid(Integer uid);
    //会员到期清空会员数据
    void updateUserVipByUId(Integer uid);
    Set<Sheet> selectCreateSheet(Integer uid);
    Set<Sheet> selectCollectionSheet(Integer uid);
}

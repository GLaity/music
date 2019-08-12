package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    //用户登录
    User selectUserByUname(String uname);
    //主键删除
    int deleteByPrimaryKey(Integer uid);
    //添加用户
    int insert(User user);
    //动态添加
    int insertSelective(User user);
    //主键查找
    User selectByPrimaryKey(Integer uid);
    //遍历用户
    List<User> selectAll();
    //主键查找动态更新
    int updateByPrimaryKeySelective(User user);
    //主键更新
    int updateByPrimaryKey(User user);


}

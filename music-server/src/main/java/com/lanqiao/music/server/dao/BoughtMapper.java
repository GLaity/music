package com.lanqiao.music.server.dao;
import com.lanqiao.music.server.pojo.Bought;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoughtMapper {
    List<Bought> selectAllBought();
    String selectUserNameByUid(Integer uid);
    void deleteBought(Integer bid);
}

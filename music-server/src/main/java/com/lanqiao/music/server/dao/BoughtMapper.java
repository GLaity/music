package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Bought;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoughtMapper {
    void insertBought(Bought bought);
}

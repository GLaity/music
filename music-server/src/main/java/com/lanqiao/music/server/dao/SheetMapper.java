package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SheetMapper {
    List<Sheet> searchAll(String sname);
}

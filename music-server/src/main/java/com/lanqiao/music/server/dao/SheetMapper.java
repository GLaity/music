package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SheetMapper {
    List<Sheet> searchAll();
    int searchId(String sname);
    public void insertSheet(Sheet sheet);
    public void insertSheetUser(@Param("sid") Integer sid, @Param("uid") Integer uid, @Param("sname") String sname, @Param("type") Integer type);
    public void insertSheetMusic(@Param("sid") Integer sid,@Param("mid") Integer mid);
    //修改歌单
    public Sheet updateSheet(Sheet sheet);
}

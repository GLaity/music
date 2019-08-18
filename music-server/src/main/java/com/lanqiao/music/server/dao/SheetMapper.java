package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SheetMapper {
    //创建歌单

    public void insertSheet(Sheet sheet);

    //修改歌单
    public Sheet updateSheet(int sid);
    //删除歌单
    public void deleteSheetUser(int uid);

    public void deleteSheet(String sname);
    //搜索歌单

}

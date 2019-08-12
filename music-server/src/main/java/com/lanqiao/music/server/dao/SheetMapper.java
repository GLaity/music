package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.SheetMusic;
import com.lanqiao.music.server.pojo.SheetUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SheetMapper {
    //创建歌单
    public void insertSheetUser(SheetUser sheetUser);
    public void insertSheet(Sheet sheet);
    public void insertSheetMusic(SheetMusic sheetMusic);
    //修改歌单
    public Sheet updateSheet(int sid);
    //删除歌单
    public void deleteSheetUser(int uid);
    public void deleteSheetMusic(SheetMusic sheetMusic);
    public void deleteSheet(String sname);
    //搜索歌单
    public List<Sheet> searchAll();
    public List<Sheet> searchBytype(Integer type);
    public List<Sheet> searchByCondition(@Param("sname") String sname, @Param("ssum") int ssum, @Param("scontext") String scontext);
    public List<Sheet> searchBySum(@Param("minSum") int minSum,@Param("maxSum") int maxSum);
    public List<Sheet> searchByMusic(String mname);
    public List<Sheet> searchByUser(String uname);
}

package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SheetMapper {
    //创建歌单
    public void insertSheet( Sheet sheet);
    public void insertSheetUser(@Param("sid") Integer sid,@Param("uid") Integer uid,@Param("sname") String sname,@Param("type") Integer type);
    public void insertSheetMusic(@Param("sid") Integer sid,@Param("mid") Integer mid);
    //修改歌单
    public Sheet updateSheet(Sheet sheet);
    //删除歌单
    public void deleteSheetUser(int uid);
    public void deleteSheet(String sname);
    public void deleteSheetMusic(@Param("sid") Integer sid ,@Param("mid")Integer mid );
    //搜索歌单
    public List<Sheet> searchAll();
    public List<Sheet> searchBytype(Integer type);
    public List<Sheet> searchByCondition(@Param("sname") String sname, @Param("ssum") int ssum, @Param("scontext") String scontext);
    public List<Sheet> searchBySum(@Param("minSum") int minSum,@Param("maxSum") int maxSum);
    public List<Sheet> searchByMusic(String mname);
    public List<Sheet> searchByUser(String uname);
}

package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SheetMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Sheet record);

    int insertSelective(Sheet record);

    Sheet selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Sheet record);

    int updateByPrimaryKey(Sheet record);
    public void insertSheetUser(@Param("sid") Integer sid, @Param("uid") Integer uid, @Param("sname") String sname, @Param("type") Integer type);
    public void insertSheetMusic(@Param("sid") Integer sid,@Param("mid") Integer mid);
    public void deleteSheetUser(int uid);
    public void deleteSheet(String sname);
    public void deleteSheetMusic(@Param("sid") Integer sid ,@Param("mid")Integer mid );
    public List<Sheet> searchAll();
    public List<Sheet> searchBytype(Integer type);
    public List<Sheet> searchByCondition(@Param("sname") String sname, @Param("ssum") int ssum, @Param("scontext") String scontext);
    public List<Sheet> searchBySum(@Param("minSum") int minSum,@Param("maxSum") int maxSum);
    public List<Sheet> searchByMusic(String mname);
    public List<Sheet> searchByUser(Integer userId);

}
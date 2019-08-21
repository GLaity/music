package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@Mapper
public interface SheetMapper {
    void insertSheet(Sheet sheet);
    void insertSheetUser(Sheet sheet);
    void updateSheet(Sheet sheet);
    Sheet selectSheetBySid(Integer sid);
    List<Sheet> selectAllSheet();
    Integer selectBySid(@Param("sid") Integer sid);
    List<Sheet> selectSheetByType(@Param("type") Integer type);
    List<Sheet> selectSheetByUserType(@Param("uid") Integer uid,
                                      @Param("type") Integer type);
    List<Music> selectMusicForSheet(@Param("sid")Integer sid);
    void insertMusicIntoSheet(@Param("sid") Integer sid,
                              @Param("mid") Integer mid);
    void deleteMusicFormSheet(@Param("sid") Integer sid,
                              @Param("mid") Integer mid);
    void insertSheetIntoUser(@Param("uid") Integer uid,
                             @Param("sid") Integer sid);
    void deleteSheetFromUser(@Param("uid") Integer uid,
                             @Param("sid") Integer sid);
}

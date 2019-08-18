package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Sheet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SheetMapper {
    void insertSheet(Sheet sheet);
    void updateSheet(Sheet sheet);
    Sheet selectSheetBySid(Integer sid);
    List<Sheet> selectAllSheet();
    List<Sheet> selectSheetByUserType(@Param("uid") Integer uid,
                                      @Param("type") Integer type);
    void insertMusicIntoSheet(@Param("sid") Integer sid,
                              @Param("mid") Integer mid);
    void deleteMusicFormSheet(@Param("sid") Integer sid,
                              @Param("mid") Integer mid);
    void insertSheetIntoUser(@Param("uid") Integer uid,
                             @Param("sid") Integer sid);
    void deleteSheetFromUser(@Param("uid") Integer uid,
                             @Param("sid") Integer sid);
}

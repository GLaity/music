package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MusicMapper {
    //添加音乐
    void insertMusic(Music music);
    //根据音乐ID删除音乐
    void deleteMusicByMId(Music music);
    //更新音乐
    void updateMusic(Music music);
    //查询所有音乐
    List<Music> selectMusicAll();
    //根据id查询音乐
    Music selectMusicByMId(Integer mid);
    //根据音乐名字模糊查询音乐
    List<Music> selectMusicByLikeName(String mname);
    List<Music> selectMusicByCondition(@Param("mname")String mname,
                                       @Param("msinger")String msinger,
                                       @Param("mlevel")Integer mlevel,
                                       @Param("mtheme")Integer mtheme,
                                       @Param("mstyle")Integer mstyle,
                                       @Param("mlanguage")Integer mlanguage,
                                       @Param("mprice")Integer mprice);
    List<Sort> selectSortByType(Integer type);
}

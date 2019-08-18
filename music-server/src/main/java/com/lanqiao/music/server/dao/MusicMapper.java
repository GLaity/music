package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MusicMapper {
    //添加音乐
//    void insertMusic(Music songs);
//    //根据音乐ID删除音乐
//    void deleteMusicByMId(Integer mid);
//    //更新音乐
//    void updateMusic(Music songs);
    //查询所有音乐
    List<Music> selectMusicAll();
    //根据id查询音乐
    Music selectMusicByMId(Integer mid);
    //根据音乐名字模糊查询音乐
    List<Music> selectMusicByLikeName(String mname);

}

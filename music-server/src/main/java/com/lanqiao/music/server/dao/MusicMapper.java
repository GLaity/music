package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MusicMapper {
    //添加音乐
    void insertMusic(Music music);
    //根据音乐ID删除音乐
    void deleteMusicByMId(Integer mid);
    //更新音乐
    void updateMusic(Music music);
    //查询所有音乐
    List<Music> selectMusicAll();
}
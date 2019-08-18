package com.lanqiao.music.server.dao;

import com.lanqiao.music.server.pojo.Advice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdviceMapper {
    Integer insertAdvice(Advice advice);
    Advice selectAdviceByAid(Integer aid);
    List<Advice> selectAdviceByUser(Integer uid);
    List<Advice> selectAdviceByMusic(Integer mid);
}

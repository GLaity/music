package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.*;

import java.util.List;

public interface ISheetService {
     void initSheet(Sheet sheet,User user,Integer type);
     void deletSheet(User user,Sheet sheet);
     List<Sheet>seach(User user);
     List<Sheet> seachByCondition(String sname, int ssum, String scontext);
     List<Sheet> seachByNum(int minSum,int maxSum);
     List<Sheet> searchByMusic(String mname);
     List<Sheet> searchAll();
     List<Sheet> searchBytype(Integer type);
     //随机从数据库里拿到20个
}

package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.*;

import java.util.List;

public interface ISheetService {
     void initSheet(Sheet sheet,User user,Integer type);
     void deletSheet(User user,Sheet sheet);
     List<Sheet> search(User user);
     List<Sheet> searchByCondition(String sname, int ssum, String scontext);
     List<Sheet> searchByNum(int minSum,int maxSum);
     List<Sheet> searchByMusic(String mname);
     List<Sheet> searchAll();
     List<Sheet> searchBytype(Integer type);

}

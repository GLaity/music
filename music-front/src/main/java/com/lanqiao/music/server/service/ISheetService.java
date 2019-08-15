package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;

import java.util.List;

public interface ISheetService {
     void initSheet(User user, String sname, String scontext, Integer type);
     void initSheetMusic(User user, Sheet sheet, List<Music> musicList);
     void deletSheet(User user, Sheet sheet);
     List<Sheet> search(User user);
     List<Sheet> searchByCondition(String sname, int ssum, String scontext);
     List<Sheet> searchByNum(int minSum, int maxSum);
     List<Sheet> searchByMusic(String mname);
     List<Sheet> searchAll();
     List<Sheet> searchBytype(Integer type);
}

package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;

import java.util.List;

public interface ISheetService {
     void initSheet(User user, String sname, String scontext, Integer type);
     void initSheetMusic(User user, Sheet sheet, List<Music> musicList);
     void deletSheet(User user, Sheet sheet);
     List<Sheet>seach(User user);
     List<Sheet> seachByCondition(String sname, int ssum, String scontext);
     List<Sheet> seachByNum(int minSum, int maxSum);
     List<Sheet> searchByMusic(String mname);
     List<Sheet> searchAll();
     List<Sheet> searchBytype(Integer type);
}

//package com.lanqiao.music.server.service.impl;
//
//import com.alibaba.dubbo.config.annotation.Service;
//import com.lanqiao.music.server.dao.SheetMapper;
//import com.lanqiao.music.server.pojo.*;
//import com.lanqiao.music.server.service.ISheetService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.List;
//
//@Component
//@Service
//public class SheetService implements ISheetService {
//    @Autowired
//    private SheetMapper sheetMapper;
//    @Override
//    public void initSheet(User user,String sname,String scontext,Integer type) {
//        SheetUser sheetUser =new SheetUser();
//        Sheet sheet =new Sheet();
//        sheet.setSname(sname);
//        sheet.setScontext(scontext);
//        sheetMapper.insertSheet(sheet);
//        sheetUser.setSname(user.getUname());
//        sheetUser.setType(type);
//        sheetUser.setUid(user.getUid());
//       sheetMapper.insertSheetUser(sheetUser);
//    }
//
//    @Override
//    public void initSheetMusic(User user,Sheet sheet,List<Music> musicList) {
//        SheetMusic sheetMusic =new SheetMusic();
//        sheetMusic.setSid(sheet.getSid());
//        for (Music music :musicList){
//            sheetMusic.setMid(music.getMid());
//        }
//        sheetMapper.insertSheetMusic(sheetMusic);
//    }
//
//    @Override
//    public void deletSheet(User user,Sheet sheet) {
//        SheetMusic sm =new SheetMusic();
//        sm.setSid(sheet.getSid());
//        sheetMapper.deleteSheetMusic(sm);
//        sheetMapper.deleteSheet(sheet.getSname());
//        sheetMapper.deleteSheetUser(user.getUid());
//    }
//
//    @Override
//    public List<Sheet> seach(User user) {
//        return  sheetMapper.searchByUser(user.getUname());
//    }
//
//    @Override
//    public List<Sheet> seachByCondition(String sname, int ssum, String scontext) {
//        return sheetMapper.searchByCondition(sname,ssum,scontext);
//    }
//
//    @Override
//    public List<Sheet> seachByNum(int minSum, int maxSum) {
//        return sheetMapper.searchBySum(minSum,maxSum);
//    }
//
//    @Override
//    public List<Sheet> searchByMusic(String mname) {
//        return sheetMapper.searchByMusic(mname);
//    }
//
//    @Override
//    public List<Sheet> searchAll() {
//        return sheetMapper.searchAll();
//    }
//
//    @Override
//    public List<Sheet> searchBytype(Integer type) {
//        return sheetMapper.searchBytype(type);
//    }
//}

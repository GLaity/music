package com.lanqiao.music.server.frontservice;

import com.lanqiao.music.server.pojo.Sheet;

import java.util.List;

public interface ISheetService {
    List<Sheet> searchAll(String sname);
}

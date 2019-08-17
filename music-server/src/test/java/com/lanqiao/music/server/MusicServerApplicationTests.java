package com.lanqiao.music.server;

import com.lanqiao.music.server.dao.SheetMapper;
import com.lanqiao.music.server.pojo.Sheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicServerApplicationTests {
    @Autowired
    private SheetMapper sheetMapper;
    @Test
    public void contextLoads() throws SQLException {
//        System.out.println("-----------");
        List<Sheet> sheets =sheetMapper.searchAll();
        System.out.println(sheets);
    }

}

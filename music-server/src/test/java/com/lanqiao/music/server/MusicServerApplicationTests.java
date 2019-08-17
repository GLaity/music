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
    private SheetMapper sheetMapper;
    @Test
    public void contextLoads() throws SQLException {
//        System.out.println("-----------");

        Sheet sheet =sheetMapper.selectByPrimaryKey(1);
        System.out.println(sheet);
    }

}

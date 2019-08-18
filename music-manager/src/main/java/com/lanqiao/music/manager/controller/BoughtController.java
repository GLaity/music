package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Bought;
import com.lanqiao.music.server.service.IBoughtService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/bought")
public class BoughtController {

    @Reference
    private IBoughtService boughtService;

    @RequestMapping("/list.do")
    public String boughtList(ModelMap map){
        List<Bought> boughtList = boughtService.getAllBought();
        for (Bought bought : boughtList){
            String user = boughtService.getUserNameByUid(bought.getUid());
            bought.setUser(user);
        }
        String size = String.valueOf(boughtList.size());
        map.addAttribute("size",size);
        map.addAttribute("boughtList",boughtList);
        return "buy-list";
    }

    @GetMapping("/delete.do/{bid}")
    public Object deleteMusic(@PathVariable Integer bid){
        boughtService.removeBought(bid);
        return "redirect:/bought/list.do";
    }

}

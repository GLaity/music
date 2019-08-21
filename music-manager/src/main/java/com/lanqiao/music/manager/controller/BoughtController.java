package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Bought;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IBoughtService;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/bought")
public class BoughtController {

    @Reference
    private IBoughtService boughtService;

    @Reference
    private IUserService userService;

    @RequestMapping("/list.do/{num}")
    public String boughtList(ModelMap map,@PathVariable Integer num){
        if(num==null){
            num=1;
        }
        List<Bought> boughtList =  boughtService.getAllBought();
        List<User> userList = userService.getAllUser();
        for (Bought bought : boughtList){
            for (User user : userList){
                if (bought.getUid()==user.getUid()){
                    bought.setUser(user.getUname());
                }
            }
        }
        Integer size = boughtList.size();
        //页面展示数据
        List<Bought> list = new ArrayList<>();
        for(int i =10;i>0;i--){
            if ((10*num-i) < size){
                list.add(boughtList.get(10*num-i));
            }
        }
        //页码
        int[] count = new int[size/10+1];
        for (int j = 0; j < size/10+1; j++){
            count[j] = j+1;
        }
        map.addAttribute("num",num);
        map.addAttribute("count",count);
        map.addAttribute("size",size);
        map.addAttribute("boughtList",list);
        return "buy-list";
    }


    @GetMapping("/delete.do/{bid}")
    public String deleteBought(ModelMap map,@PathVariable Integer bid){
        boughtService.removeBought(bid);
        return "redirect:/bought/list.do/1";
    }

    @RequestMapping("/selectdel.do")
    public String selectdelBought(ModelMap map,HttpServletRequest request){
        String[] checkbox = request.getParameterValues("checkbox");
        if (checkbox != null){
            for (String bid : checkbox){
                boughtService.removeBought(Integer.valueOf(bid));
            }
        }
        return "redirect:/bought/list.do/1";
    }


//    public Object deleteMusic(@PathVariable Integer bid){
//        Map<String,Object> map = new HashMap<>();
//        boughtService.removeBought(bid);
//        List<Bought> boughtList = boughtService.getAllBought();
//        map.put("count",boughtList.size());
//        map.put("msg","删除成功！");
//        return map;
//    }

//    @ResponseBody
//    @RequestMapping("/selectdel.do")
//    public Object selectdelMusic(HttpServletRequest request){
//        String[] checkbox = request.getParameterValues("checkbox");
//        for (String bid : checkbox){
//            boughtService.removeBought(Integer.valueOf(bid));
//        }
//        List<Bought> boughtList = boughtService.getAllBought();
//        Map<String,Object> map = new HashMap<>();
//        map.put("count",boughtList.size());
//        map.put("bids",checkbox);
//        map.put("msg","删除成功！");
//        return map;
//    }
}

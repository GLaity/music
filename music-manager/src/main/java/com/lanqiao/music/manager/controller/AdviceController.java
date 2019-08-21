package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Advice;
import com.lanqiao.music.server.service.IAdviceService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("/advice")
public class AdviceController {

    @Reference
    private IAdviceService adviceService;

    @RequestMapping("/list.do/{num}")
    public String adviceList(ModelMap map,@PathVariable Integer num){
        if(num==null){
            num=1;
        }
        List<Map> mapList = new ArrayList();
        List<Advice> adviceList = adviceService.getAllAdvice();
        for (Advice advice : adviceList){
            Map<String,Object> m = new HashMap();
            String uname = adviceService.getUserNameByUid(advice.getUid());
            String mname = adviceService.getMusicNameByMid(advice.getMid());
            m.put("aid", advice.getAid());
            m.put("uname",uname);
            m.put("mname",mname);
            m.put("atext",advice.getAtext());
            m.put("adate", advice.getAdate());
            mapList.add(m);
        }
        Integer size = adviceList.size();
        //页面展示数据
        List<Map> list = new ArrayList<>();
        for(int i =10;i>0;i--){
            if ((10*num-i) < size){
                list.add(mapList.get(10*num-i));
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
        map.addAttribute("mapList",list);
        return "advice-list";
    }

    @ResponseBody
    @GetMapping("/delete.do/{aid}")
    public Object deleteMusic(@PathVariable Integer aid){
        Map<String,Object> map = new HashMap<>();
        adviceService.removeAdvice(aid);
        List<Advice> adviceList = adviceService.getAllAdvice();
        map.put("count",adviceList.size());
        map.put("msg","删除成功！");
        return map;
    }

    @RequestMapping("/selectdel.do")
    public String selectdelAdvice(ModelMap map, HttpServletRequest request){
        String[] checkbox = request.getParameterValues("checkbox");
        if (checkbox != null){
            for (String aid : checkbox){
                adviceService.removeAdvice(Integer.valueOf(aid));
            }
        }
        return "redirect:/advice/list.do/1";
    }
}

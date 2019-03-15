package com.zhonghaollc.zhonghaosite.controller;

import com.zhonghaollc.zhonghaosite.entity.HomeBannerSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeServicesSectionEntity;
import com.zhonghaollc.zhonghaosite.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    HomeService homeService;

    @RequestMapping({"/home","/"})
    public String homepage(Model model){
        String name = "runqi";
        model.addAttribute("name", name);
        model.addAttribute("bannerList", homeService.getAllHomeBannerSectionEntities());
        model.addAttribute("featuresList", homeService.getAllHomeFeaturesSectionEntities());
        model.addAttribute("chartInfo", homeService.getHomeChartSection());
        List<HomeServicesSectionEntity> list = homeService.getAllHomeServicesSectionEntities();
        model.addAttribute("serviceBig",list.get(0));
        list.remove(list.get(0));
        model.addAttribute("serviceList", list);
        System.out.println(list);
        return "index";
    }

    @RequestMapping({"/about"})
    public String aboutPage(Model model){
        return "about";
    }

}

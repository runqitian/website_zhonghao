package com.zhonghaollc.zhonghaosite.controller;

import com.zhonghaollc.zhonghaosite.entity.HomeBannerSectionEntity;
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
        System.out.println(homeService.getAllHomeBannerSectionEntities().size());
        List<HomeBannerSectionEntity> list = homeService.getAllHomeBannerSectionEntities();
        model.addAttribute("bannerBig", list.get(0));
        model.addAttribute("bannerList", list.remove(list.get(0)));
        model.addAttribute("featuresList", homeService.getAllHomeFeaturesSectionEntities());
        model.addAttribute("chartInfo", homeService.getHomeChartSection());
        model.addAttribute("serviceList",homeService.getAllHomeServicesSectionEntities());
        return "index";
    }

    @RequestMapping({"/about"})
    public String aboutPage(Model model){
        return "about";
    }

}

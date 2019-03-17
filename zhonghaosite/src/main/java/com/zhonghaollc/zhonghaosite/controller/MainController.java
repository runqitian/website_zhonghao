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
        model.addAttribute("serviceList", homeService.getAllHomeServicesSectionEntities());
        return "index";
    }

    @RequestMapping({"/about"})
    public String aboutPage(Model model){
        String title = "title";
        String text = "text";
        String imgPath = "images/about/about.jpg";
        model.addAttribute("title", title);
        model.addAttribute("text", text);
        model.addAttribute("imgPath",imgPath);
        return "about";
    }

    @RequestMapping({"/contact"})
    public String contactPage(Model model){
        return "contact";
    }
}

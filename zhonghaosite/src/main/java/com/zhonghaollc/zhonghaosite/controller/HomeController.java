package com.zhonghaollc.zhonghaosite.controller;


//import com.sun.xml.internal.ws.developer.Serialization;
import com.zhonghaollc.zhonghaosite.dao.S3AccessObject;
import com.zhonghaollc.zhonghaosite.entity.HomeBannerSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeChartSection;
import com.zhonghaollc.zhonghaosite.entity.HomeFeaturesSectionEntity;
import com.zhonghaollc.zhonghaosite.entity.HomeServicesSectionEntity;
import com.zhonghaollc.zhonghaosite.service.HomeService;
import com.zhonghaollc.zhonghaosite.service.UpdateService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    UpdateService updateService;


    @GetMapping("/index/new")
    public String hello(){
        try {
            updateService.updateIndex();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "success";
    }

//    @GetMapping("/contact/new")
//    public String contact(){
//
//    }




}

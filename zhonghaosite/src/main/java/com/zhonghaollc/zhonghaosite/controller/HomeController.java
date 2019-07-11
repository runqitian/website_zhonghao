package com.zhonghaollc.zhonghaosite.controller;


//import com.sun.xml.internal.ws.developer.Serialization;
import com.zhonghaollc.zhonghaosite.service.UpdateService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    UpdateService updateService;


    @GetMapping("/index/new")
    public String hello(){
        updateService.updateIndex();
        return "success";
    }

//    @GetMapping("/contact/new")
//    public String contact(){
//
//    }




}

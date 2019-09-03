package com.zhonghaollc.zhonghaosite.controller;


//import com.sun.xml.internal.ws.developer.Serialization;
import com.zhonghaollc.zhonghaosite.entity.msg.Message;
import com.zhonghaollc.zhonghaosite.service.UpdateService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/server")
public class ServerController {

    @Autowired
    UpdateService updateService;

    @GetMapping("/new/index")
    public Message updateIndex(){
        updateService.updateIndex();
        return new Message();
    }

    @GetMapping("/new/contact")
    public Message updateContact(){
        updateService.updateContact();
        return new Message();
    }

    @GetMapping("/new/about")
    public Message updateAbout(){
        updateService.updateAbout();
        return new Message();
    }

    @GetMapping("/new/service")
    public Message updateServicePage(){
        updateService.updateServicePage();
        return new Message();
    }

}

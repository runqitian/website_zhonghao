package com.zhonghaollc.zhonghaosite.service;


import com.zhonghaollc.zhonghaosite.dao.S3AccessObject;
import com.zhonghaollc.zhonghaosite.entity.about.AboutPage;
import com.zhonghaollc.zhonghaosite.entity.contact.ContactPage;
import com.zhonghaollc.zhonghaosite.entity.index.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

@org.springframework.stereotype.Service
public class UpdateService {

    @Autowired
    S3AccessObject s3AccessObject;

    public void updateIndex() {
        try {
            IndexPage indexPage = s3AccessObject.indexPageDao();

            Configuration cfg = setUpConfiguration();

            Map<String, Object> input = new HashMap<String, Object>();
            input.put("indexPage", indexPage);

            Template template = cfg.getTemplate("index.html");

            generateStatic(template, input, "index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateContact(){
        try {
            ContactPage contactPage = s3AccessObject.contactPageDao();

            Configuration cfg = setUpConfiguration();

            Map<String, Object> input = new HashMap<String, Object>();
            input.put("contactPage", contactPage);

            Template template = cfg.getTemplate("contact.html");

            generateStatic(template, input, "contact.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateAbout(){
        try {
            AboutPage aboutPage = s3AccessObject.aboutPageDao();

            Configuration cfg = setUpConfiguration();

            Map<String, Object> input = new HashMap<String, Object>();
            input.put("aboutPage", aboutPage);

            Template template = cfg.getTemplate("about.html");

            generateStatic(template, input, "about.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Configuration setUpConfiguration(){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setClassForTemplateLoading(UpdateService.class, "/temporary/");
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }

    private void generateStatic(Template template, Map<String, Object> input, String savename) throws Exception{
        File tmpResource = new File(UpdateService.class.getClassLoader().getResource("").getPath() + File.separator + "templates");
        if (!tmpResource.exists()) {
            tmpResource.mkdir();
        }

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File(tmpResource.getPath() + File.separator + savename));
        try {
//                template.process(input, fileWriter);
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }
    }

}

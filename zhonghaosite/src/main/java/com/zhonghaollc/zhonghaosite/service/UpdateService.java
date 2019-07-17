package com.zhonghaollc.zhonghaosite.service;


import com.zhonghaollc.zhonghaosite.dao.S3AccessObject;
import com.zhonghaollc.zhonghaosite.entity.about.AboutPage;
import com.zhonghaollc.zhonghaosite.entity.contact.ContactPage;
import com.zhonghaollc.zhonghaosite.entity.index.*;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.*;

@org.springframework.stereotype.Service
public class UpdateService {

    @Value("${html_dir}")
    private String htmlDir;

    @Value("${temp_dir}")
    private String tempDir;

    @Autowired
    S3AccessObject s3AccessObject;

    @Value("${site_dir}")
    String siteDir;

    private String currentDir;

    public UpdateService(){
        String temp = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if (temp.endsWith("/")){
            temp = temp.substring(0,temp.length()-1);
        }
        String[] items = temp.split(File.separator);
        currentDir = temp.replace(items[items.length- 1], "");
        System.out.println(currentDir);
    }

    public void uploadStatics(){

    }

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

    public void updateStatics(){

    }


    private Configuration setUpConfiguration(){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        FileTemplateLoader ftl = null;
        try {
             ftl = new FileTemplateLoader(new File(currentDir + tempDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cfg.setTemplateLoader(ftl);
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }

    private void generateStatic(Template template, Map<String, Object> input, String savename) throws Exception{
        String dirPath = siteDir;
        if (siteDir.equals("default")){
            dirPath = currentDir + htmlDir;
        }
        File tmpResource = new File(dirPath);
        if (!tmpResource.exists()) {
            tmpResource.mkdir();
        }
        System.out.println(dirPath);
        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File(tmpResource.getPath() + File.separator + savename));
        try {
//                template.process(input, fileWriter);
            template.process(input, fileWriter);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fileWriter.close();
        }
    }

}

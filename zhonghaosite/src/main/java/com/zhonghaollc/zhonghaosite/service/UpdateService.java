package com.zhonghaollc.zhonghaosite.service;


import com.zhonghaollc.zhonghaosite.dao.S3AccessObject;
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
//            System.out.println(indexPage);

            // 1. Configure FreeMarker
            //
            // You should do this ONLY ONCE, when your application starts,
            // then reuse the same Configuration object elsewhere.

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

            // Where do we load the templates from:
            cfg.setClassForTemplateLoading(UpdateService.class, "/temporary/");

            // Some other recommended settings:
            cfg.setIncompatibleImprovements(new Version(2, 3, 20));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setLocale(Locale.US);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            // 2. Proccess template(s)
            //
            // You will do this for several times in typical applications.

            // 2.1. Prepare the template input:

            Map<String, Object> input = new HashMap<String, Object>();
            input.put("indexPage", indexPage);

            // 2.2. Get the template

            Template template = cfg.getTemplate("index.html");

            // 2.3. Generate the output

            // Write output to the console
//            Writer consoleWriter = new OutputStreamWriter(System.out);
//            template.process(input, consoleWriter);
            File tmpResource = new File(UpdateService.class.getClassLoader().getResource("").getPath() + File.separator + "templates");
            if (!tmpResource.exists()) {
                tmpResource.mkdir();
            }

            // For the sake of example, also write output into a file:
            Writer fileWriter = new FileWriter(new File(tmpResource.getPath() + File.separator + "index.html"));
            try {
//                template.process(input, fileWriter);
                template.process(input, fileWriter);
            } finally {
                fileWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateContact(){

    }

    public void updateAbout(){

    }

}

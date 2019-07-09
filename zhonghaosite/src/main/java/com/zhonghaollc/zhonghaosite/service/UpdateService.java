package com.zhonghaollc.zhonghaosite.service;


import com.zhonghaollc.zhonghaosite.dao.S3AccessObject;
import com.zhonghaollc.zhonghaosite.entity.HomeBannerSectionEntity;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class UpdateService {

    @Autowired
    S3AccessObject s3AccessObject;

    public void updateIndex() throws IOException, TemplateException {

//        s3AccessObject.updateIndexDownload();

        // 1. Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.

        Configuration cfg = new Configuration();

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(UpdateService.class, "/templates");

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

        input.put("banner", new HomeBannerSectionEntity("sub","MAIN","text","imag"));


        // 2.2. Get the template

        Template template = cfg.getTemplate("index.html");

        // 2.3. Generate the output

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("output2.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }

}

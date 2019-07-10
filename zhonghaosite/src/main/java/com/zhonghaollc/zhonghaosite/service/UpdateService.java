package com.zhonghaollc.zhonghaosite.service;


import com.zhonghaollc.zhonghaosite.dao.S3AccessObject;
import com.zhonghaollc.zhonghaosite.entity.*;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class UpdateService {

    @Autowired
    S3AccessObject s3AccessObject;

    public void updateIndex() throws IOException, TemplateException {

        //s3AccessObject.updateIndexDownload();

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

        List<HomeFeaturesSectionEntity> featureList = new ArrayList<>();
        featureList.add(new HomeFeaturesSectionEntity("Electrical Equipment Trade",
                "The Company will brokerage services for a selection of electrical equipment procured" +
                        " from U.S.-based manufacturers and imported from China.", "images/home/features/feature1.png"));
        featureList.add(new HomeFeaturesSectionEntity("Chemicals Trade",
                "Zhonghao International LLC will offer a variety of chemicals and related products,\n" +
                        "including compressed gas, chemical additives, catalytic agents, and synthetic rubber,\n" +
                        "to the manufacturing, construction, and mining industries.", "images/home/features/feature2.png"));
        input.put("featureList", featureList);

        input.put("history", new HomeHistorySectionEntity("OUR SHORT HISTORY",
                "Our long-term goal is to become the preferred import company for the chemical and mining industry."));

        input.put("chart", new HomeChartSection("U.S. International Trade in Goods and Services",
                "Now being impacted by the global economy, trading goods and services among different countries has been a significant part for business." +
                        "According to the data from Bureau of Economic Analysis, " +
                        "exports were $2,500.0 billion in 2018, up $148.9 billion from 2017. " +
                        "Imports were $3,121.0 billion, up $217.7 billion from 2017. " +
                        "Even though trading business is absolutely affected by the policy preference and economic trends, " +
                        "it still demonstrates a increasing lines in not only exports but also imports of US.",
                "images/home/chart/chart.png",
                "[1] Source: IBISWorld, Wholesale Trade Agents and Brokers Industry, Industry Report 2018"));

        List<HomeServicesSectionEntity> serviceList = new ArrayList<>();
        serviceList.add(new HomeServicesSectionEntity("Supplier & Buyer Identification", "", "images/home/services/icon1.png"));
        serviceList.add(new HomeServicesSectionEntity("Contracting & Consulting", "", "images/home/services/icon2.png"));
        serviceList.add(new HomeServicesSectionEntity("Shipping Setup", "", "images/home/services/icon3.png"));
        serviceList.add(new HomeServicesSectionEntity("Warehousing Arrangements", "", "images/home/services/icon4.png"));
        serviceList.add(new HomeServicesSectionEntity("Delivery", "", "images/home/services/icon5.png"));
        input.put("serviceList", serviceList);

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

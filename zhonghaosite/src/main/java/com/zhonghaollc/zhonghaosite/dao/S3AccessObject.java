package com.zhonghaollc.zhonghaosite.dao;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
//import com.zhonghaollc.zhonghaosite.ZhonghaositeApplication;
import com.zhonghaollc.zhonghaosite.entity.about.AboutPage;
import com.zhonghaollc.zhonghaosite.entity.contact.ContactPage;
import com.zhonghaollc.zhonghaosite.entity.index.IndexPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.*;

@Repository
public class S3AccessObject {
    @Value("${temp_dir}")
    private String tempDir;

    @Value("${s3_prefix}")
    private String s3Prefix;

    @Value("${s3_bucket}")
    private String s3Bucket;

    private AmazonS3 s3;

    private String currentDir;


    public S3AccessObject(){
        s3 = AmazonS3ClientBuilder.defaultClient();
        String temp = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if (temp.endsWith("/")){
            temp = temp.substring(0,temp.length()-1);
        }
        String[] items = temp.split(File.separator);
        currentDir = temp.replace(items[items.length- 1], "");
        System.out.println(currentDir);
    }


    public void staticsDao() throws Exception {
    }

    public IndexPage indexPageDao() throws Exception {
//        resourcePath = ZhonghaositeApplication.class.getClassLoader().getResource("").getPath();
        downloadFileFromS3( "contents/index.json", "index.json");
        downloadFileFromS3("templates/index.html","index.html");
        downloadFileFromS3("templates/header.ftl", "header.ftl");
        downloadFileFromS3("templates/footer.ftl", "footer.ftl");

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(currentDir + tempDir + File.separator + "index.json"));
        IndexPage indexPage = gson.fromJson(reader, IndexPage.class);

        return indexPage;
    }

    public AboutPage aboutPageDao() throws Exception{
        downloadFileFromS3( "contents/about.json", "about.json");
        downloadFileFromS3("templates/about.html","about.html");
        downloadFileFromS3("templates/header.ftl", "header.ftl");
        downloadFileFromS3("templates/footer.ftl", "footer.ftl");

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(currentDir + tempDir + File.separator + "about.json"));
        AboutPage aboutPage = gson.fromJson(reader, AboutPage.class);

        return aboutPage;
    }

    public ContactPage contactPageDao() throws Exception{
        downloadFileFromS3( "contents/contact.json", "contact.json");
        downloadFileFromS3("templates/contact.html","contact.html");
        downloadFileFromS3("templates/header.ftl", "header.ftl");
        downloadFileFromS3("templates/footer.ftl", "footer.ftl");

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(currentDir + tempDir + File.separator + "contact.json"));
        ContactPage contactPage = gson.fromJson(reader, ContactPage.class);

        return contactPage;
    }


    private void writeInputStream(InputStream input, String writePath){
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try{
            reader = new BufferedReader(new InputStreamReader(input));
            writer = new BufferedWriter(new FileWriter(writePath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(writePath);
        }
    }

    private void downloadFileFromS3(String path, String saveName){
        S3Object indexJSON = s3.getObject(new GetObjectRequest(s3Bucket,s3Prefix + File.separator + path));
        File tmpResource = new File(currentDir + tempDir);
        if (!tmpResource.exists()){
            tmpResource.mkdir();
        }

        writeInputStream(indexJSON.getObjectContent(), tmpResource.getPath() + File.separator + saveName);
    }

}

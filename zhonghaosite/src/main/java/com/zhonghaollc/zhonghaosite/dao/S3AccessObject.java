package com.zhonghaollc.zhonghaosite.dao;

import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class S3AccessObject {

    @Value("${tmp}")
    private String tmpDir;

    private AmazonS3 s3;
    private String resourcePath;

    public S3AccessObject(){
        s3 = new AmazonS3Client();
        resourcePath = S3AccessObject.class.getClassLoader().getResource("").getPath();
    }

    public void updateIndexDownload() throws IOException {
        S3Object indexJSON = s3.getObject(new GetObjectRequest("zhonghaollc", "website-resource/modify/contents/index.json"));
        S3Object indexHTML = s3.getObject(new GetObjectRequest("zhonghaollc", "website-resource/modify/templates/index.html"));
        S3Object headerFTL = s3.getObject(new GetObjectRequest("zhonghaollc", "website-resource/modify/templates/header-template.ftl"));
//        indexJSON.getObjectContent();
//        indexHTML.getObjectContent();
        File tmpResource = new File(resourcePath + File.separator + tmpDir);
        if (!tmpResource.exists()){
            tmpResource.mkdir();
        }
        System.out.println(tmpResource.getPath());
        S3AccessObject.writeInputStream(indexJSON.getObjectContent(), tmpResource.getPath() + File.separator + "index.json");
        S3AccessObject.writeInputStream(indexHTML.getObjectContent(), tmpResource.getPath() + File.separator + "index.html");
        S3AccessObject.writeInputStream(headerFTL.getObjectContent(), tmpResource.getPath() + File.separator + "header-template.ftl");
    }

    public void updateContactDownload() throws Exception{

    }

    private static void writeInputStream(InputStream input, String writePath){
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try{
            reader = new BufferedReader(new InputStreamReader(input));
            writer = new BufferedWriter(new FileWriter(writePath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
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
}

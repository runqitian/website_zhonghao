package com.zhonghaollc.zhonghaosite.dao;

import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class S3AccessObject {
    static{
    }
    private AmazonS3 s3 = null;

    public S3AccessObject(){
        s3 = new AmazonS3Client();
        System.setProperty(SDKGlobalConfiguration.ENABLE_S3_SIGV4_SYSTEM_PROPERTY, "true");
    }

    public void updateIndexDownload() throws IOException {
        S3Object indexHtml = s3.getObject(new GetObjectRequest("zhonghaollc", "website-resource/modify/templates/index.html"));
        indexHtml.getObjectContent();
        S3AccessObject.writeInputStream(indexHtml.getObjectContent(),"./demo.html");
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
                System.out.println(line);
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
        }
        System.out.println();
    }
}

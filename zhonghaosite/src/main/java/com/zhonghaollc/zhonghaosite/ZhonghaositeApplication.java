package com.zhonghaollc.zhonghaosite;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@MapperScan("com.zhonghaollc.zhonghaosite.mapper")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ZhonghaositeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhonghaositeApplication.class, args);

    }

}

package com.example.ggwp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GgwpApplication {

    public static void main(String[] args) {
        SpringApplication.run(GgwpApplication.class, args);
    }

}

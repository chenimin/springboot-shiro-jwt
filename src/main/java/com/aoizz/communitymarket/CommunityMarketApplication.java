package com.aoizz.communitymarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CommunityMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityMarketApplication.class, args);
    }

}

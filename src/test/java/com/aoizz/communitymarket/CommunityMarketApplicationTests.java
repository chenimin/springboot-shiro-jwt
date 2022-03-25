package com.aoizz.communitymarket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CommunityMarketApplicationTests {

    @Test
    void contextLoads() {
        String test = "view,edit";
        List<String> strings = Arrays.asList(test.split(","));
        System.out.println(strings);
    }

}

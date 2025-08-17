package com.example.locationserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocationServerApplicationTests {


    @Autowired Service service ;
    @Test
    void contextLoads() {
//        service.sendSimpleEmail("phamnamthang1978@gmail.com","None","Thử Nghiệm Ứng Dụng");
        service.sendSimpleEmail("fileinput.txt@gmail.com","None","Thử Nghiệm Ứng Dụng");
    }

}

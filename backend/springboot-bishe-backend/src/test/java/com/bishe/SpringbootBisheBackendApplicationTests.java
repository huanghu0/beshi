package com.bishe;

import com.bishe.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBisheBackendApplicationTests {
    @Autowired
    private User user;
    @Test
    void contextLoads() {
        user.setName("黄虎");
        user.setAge(22);
        user.setSex(1);
        System.out.println(user);
    }

}

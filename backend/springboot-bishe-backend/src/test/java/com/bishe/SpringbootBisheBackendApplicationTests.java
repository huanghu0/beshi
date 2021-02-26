package com.bishe;

import com.bishe.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootBisheBackendApplicationTests {
//    @Autowired
//    private User user;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
//        user.setName("黄虎");
//        user.setAge(22);
//        user.setSex(1);
//        System.out.println(user);

        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}

package com.bishe;

import com.bishe.pojo.User;
import com.bishe.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootBisheBackendApplicationTests {
//    @Autowired
//    private User user;
//    @Autowired
//    DataSource dataSource;
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @Test
    void testRedisUtil(){
        redisUtil.set("name","huanghu");
        System.out.println(redisUtil.get("name"));
    }
    @Test
    void contextLoads() throws SQLException {
//        user.setName("黄虎");
//        user.setAge(22);
//        user.setSex(1);
//        System.out.println(user);

//        System.out.println(dataSource.getClass());
//
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        connection.close();
        User user = new User(1,"黄虎","m",22);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}

package com.bishe;

import com.alibaba.fastjson.JSON;
import com.bishe.pojo.Treeproductchildren;
import com.bishe.pojo.User;
import com.bishe.utils.RedisUtil;
import com.bishe.utils.TreeUtil;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
//import com.alibaba.fastjson.JSONObject;
//import javax.sql.DataSource;
//import net.sf.json.JSONSerializer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    @Test void Treetest(){
        List<Treeproductchildren> treeproductchildrenList = new ArrayList<>();
        treeproductchildrenList.add(new Treeproductchildren(1,0,"产品层次结构","所有",100));
        treeproductchildrenList.add(new Treeproductchildren(2,1,"火车","快车",1));
        treeproductchildrenList.add(new Treeproductchildren(3,2,"火车头","尖头",1));
        treeproductchildrenList.add(new Treeproductchildren(4,2,"火车轮","50cm",100));
        treeproductchildrenList.add(new Treeproductchildren(5,1,"轮船","邮轮",1));
        Treeproductchildren treeproductchildren = TreeUtil.getInstance().enquireTree(treeproductchildrenList);
        System.out.println(JSON.toJSONString(treeproductchildren));
//        JsonSerializer.toJSON(treeproductchildren).toString();
    }
}

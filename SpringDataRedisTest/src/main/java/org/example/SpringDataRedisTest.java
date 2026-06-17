package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;

@SpringBootTest(classes = MainApplication.class)
public class SpringDataRedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void StudentInfoTest() {
        // 1. 获取 HashOperations 对象

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        // 2. 使用学号作为 key
        String studentId = "23852545";

        // 3. 使用 put 方法设置个人信息（field 分别是姓名、性别、年龄、班级）
        hashOperations .put("23852545", "姓名", "李华蕊");
        hashOperations .put("23852545", "性别", "女");
        hashOperations .put("23852545", "年龄", 22);
        hashOperations .put("23852545", "班级", "软件2507班");

        System.out.println("个人信息已存入 Redis！");


        List values=hashOperations.values("23852545");
        System.out.println(values);
    }
}
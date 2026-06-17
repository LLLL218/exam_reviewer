package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;

@SpringBootTest(classes = MainApplication.class)
public class SpringDataRedisTest3 {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void StudentInfoTest3() {
        // 1. 获取 HashOperations 对象

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        // 2. 使用学号作为 key
        String studentId = "23852566";

        // 3. 使用 put 方法设置个人信息（field 分别是姓名、性别、年龄、班级）
        hashOperations .put("23852566", "姓名", "liu zi lin");
        hashOperations .put("23852566", "性别", "男");
        hashOperations .put("23852566", "年龄", 25);
        hashOperations .put("23852566", "班级", "软件2508班");

        System.out.println("个人信息已存入 Redis！");


        List values=hashOperations.values("23852566");
        System.out.println(values);
    }
}

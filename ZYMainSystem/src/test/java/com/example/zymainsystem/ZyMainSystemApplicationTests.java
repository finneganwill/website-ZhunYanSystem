package com.example.zymainsystem;

import com.example.zymainsystem.pojo.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZyMainSystemApplicationTests {

    @Test
    void contextLoads() {
        Logger logger = LoggerFactory.getLogger(ZyMainSystemApplicationTests.class);
        User user = new User();
        user.setAlias("偷懒的橘子");
        logger.info(user.getAlias());
        logger.info(user.toString());
    }

}

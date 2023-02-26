package com.lwl.lwlapiinterface;

import com.lwl.lwlapiclientsdk.client.LwlapiClient;
import com.lwl.lwlapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LwlapiInterfaceApplicationTests {
    @Resource
    private LwlapiClient lwlapiClient;

    @Test
    void contextLoads() {
        String result = lwlapiClient.getName("lwl");
        User user = new User();
        user.setUsername("lwl");
        String usernameByPost = lwlapiClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}

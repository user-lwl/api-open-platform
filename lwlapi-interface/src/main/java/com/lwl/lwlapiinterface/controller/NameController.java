package com.lwl.lwlapiinterface.controller;

import com.lwl.lwlapiclientsdk.model.User;
import com.lwl.lwlapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author user-lwl
 * @createDate 2023/2/22 9:22
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getName(String name) {
        return "GET你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        // 实际查库
//        if (!accessKey.equals("lwl")) {
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 1000000) {
//            throw new RuntimeException("无权限");
//        }
//        // 校验
//        String serverSign = SignUtils.getSign(body, "123456");
//        if (!sign.equals(serverSign)) {
//            throw new RuntimeException("无权限");
//        }
        return "POST用户的名字是" + user.getUsername();
    }
}

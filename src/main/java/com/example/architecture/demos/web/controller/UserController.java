package com.example.architecture.demos.web.controller;

import com.example.architecture.demos.web.dto.LoginResponse;
import com.example.architecture.demos.web.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public LoginResponse login(String username, String password){
        try {
            userService.checkLogin(username,password);
            System.out.println("密码正确");
            return new LoginResponse(200, "请求成功");
        } catch (Exception e) {
            System.out.println("密码错误");
            return new LoginResponse(201, "请求失败");
        }
    }
}

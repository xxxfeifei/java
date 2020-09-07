package com.blog.test;

import com.blog.javabean.User;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        User user = new User(null, "hello", "hello", "hello@qq.com");
        userService.registerUser(user);
    }

    @Test
    public void login() {
    }

    @Test
    public void existsUsername() {
    }
}
package com.blog.test;

import com.blog.dao.UserDao;
import com.blog.dao.impl.UserDaoImpl;
import com.blog.javabean.User;

import static org.junit.Assert.*;

public class UserDaoTest {
UserDao userDao = new UserDaoImpl();
    @org.junit.Test
    public void queryUserByUsername() {
        User admin = userDao.queryUserByUsername("admin");
        System.out.println(admin);
    }

    @org.junit.Test
    public void queryUserByUsernameAndPassword() {
    }

    @org.junit.Test
    public void saveUser() {
    }
}
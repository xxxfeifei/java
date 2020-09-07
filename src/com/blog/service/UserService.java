package com.blog.service;


import com.blog.javabean.User;

public interface UserService {
    /**
     * 注册账户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @return
     */
    public boolean existsUsername(String username);
}

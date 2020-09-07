package com.blog.web;

import com.blog.javabean.User;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //检查用户名是否可用
        if(!userService.existsUsername(username)){
            //可用
            User regUser = new User(null,username,password,email);
            userService.registerUser(regUser);
            req.getRequestDispatcher("/html/regist_success.html").forward(req,resp);
//            resp.sendRedirect("http://localhost:8080/myblog/html/regist_success.html");
        }else {
            //不可用
            req.setAttribute("msg","用户名已存在！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/html/regiset.html").forward(req,resp);
//            resp.sendRedirect("http://localhost:8080/myblog/html/regiset.html");
        }


    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser != null) {
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/html/home.html").forward(req,resp);
//            resp.sendRedirect("http://localhost:8080/myblog/html/home.html");
        }else {
            req.getRequestDispatcher("/index.html").forward(req,resp);
//            resp.sendRedirect("http://localhost:8080/myblog/index.html");
        }





    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        boolean b = userService.existsUsername(username);

        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("b",b);

        Gson gson = new Gson();
        String s = gson.toJson(resultMap);

        resp.getWriter().write(s);
    }

}

package com.blog.web;

import com.blog.javabean.Article;
import com.blog.javabean.User;
import com.blog.service.ArticleService;
import com.blog.service.impl.ArticleServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogServlet extends BaseServlet {

    ArticleService articleService = new ArticleServiceImpl();

    /**
     * 文章发表功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        String title = req.getParameter("title");
        String text = req.getParameter("text");

        Article article = new Article(null, title, text, user.getUsername());
        articleService.addText(article);

        req.getRequestDispatcher("/html/home.html").forward(req,resp);
//        resp.sendRedirect("http://localhost:8080/myblog/html/home.html");
    }

    /**
     * 展示所有博客
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void allBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        List<Article> articles = articleService.queryArticleByUsername(user.getUsername());
        Integer blogCount = articleService.queryCount(user.getUsername());

        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("articles",articles);
        resultMap.put("blogCount",blogCount);

        Gson gson = new Gson();
        String s = gson.toJson(resultMap);
        System.out.println(s);

        resp.getWriter().write(s);
    }

    protected void oneBlog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        Integer id = new Integer(idString);

        Article article = articleService.queryArticleById(id);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("article",article);

        Gson gson = new Gson();
        String s = gson.toJson(resultMap);
        System.out.println(s);

        resp.getWriter().write(s);

    }
}

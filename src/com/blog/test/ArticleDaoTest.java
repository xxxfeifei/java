package com.blog.test;

import com.blog.dao.ArticleDao;
import com.blog.dao.impl.ArticleDaoImpl;
import com.blog.javabean.Article;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArticleDaoTest {
ArticleDao articleDao = new ArticleDaoImpl();
    @Test
    public void addText() {
        Article article = new Article(null, "你好吗", "反反复复烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦顶顶顶顶顶顶顶顶顶顶顶", "1");
        articleDao.addText(article);
    }

    @Test
    public void deleteTextById() {
    }

    @Test
    public void queryArticleByUsername() {
        String username = "admin";
        List<Article> articles = articleDao.queryArticleByUsername(username);
        for (Article article:articles
             ) {
            System.out.println(article);

        }
    }

    @Test
    public void queryCount(){
        String username = "admin";

        System.out.println(articleDao.queryCount(username));
    }
}
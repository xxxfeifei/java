package com.blog.service.impl;

import com.blog.dao.ArticleDao;
import com.blog.dao.impl.ArticleDaoImpl;
import com.blog.javabean.Article;
import com.blog.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    ArticleDao articleDao = new ArticleDaoImpl();

    @Override
    public int addText(Article article) {
        return articleDao.addText(article);
    }

    @Override
    public int deleteTextById(int id) {
        return articleDao.deleteTextById(id);
    }

    @Override
    public List<Article> queryArticleByUsername(String username) {
        return articleDao.queryArticleByUsername(username);
    }

    @Override
    public Article queryArticleById(Integer id) {
        return articleDao.queryArticleById(id);
    }

    @Override
    public Integer queryCount(String username) {
       return articleDao.queryCount(username);
    }
}

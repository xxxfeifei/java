package com.blog.dao.impl;

import com.blog.dao.ArticleDao;
import com.blog.javabean.Article;

import java.util.List;

public class ArticleDaoImpl extends BaseDao implements ArticleDao {

    @Override
    public int addText(Article article) {
        String sql = "insert into t_article(title,main,username)values(?,?,?)";
        return update(sql,article.getTitle(),article.getMain(),article.getUsername());
    }

    @Override
    public int deleteTextById(int id) {
        String sql = "delete from t_article where id=?";
        return update(sql,id);
    }

    @Override
    public List<Article> queryArticleByUsername(String username) {
        String sql = "select id,title,main from t_article where username=?";
        return queryForList(Article.class,sql,username);
    }

    @Override
    public Article queryArticleById(Integer id) {
        String sql = "select title,main from t_article where id=?";
        return queryForOne(Article.class,sql,id);
    }

    @Override
    public Integer queryCount(String username) {
        String sql = "select count(*) from t_article where username=?";
        return ((Number) queryForValue(sql,username)).intValue();
    }
}

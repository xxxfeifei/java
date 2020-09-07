package com.blog.service;

import com.blog.javabean.Article;

import java.util.List;

public interface ArticleService {

    /**
     * 增加一篇文章
     * @return
     */
    public int addText(Article article);

    /**
     * 删除一篇文章
     * @return
     */
    public int deleteTextById(int id);

    /**
     * 查询所有的文章
     * @return
     */
    public List<Article> queryArticleByUsername(String username);

    /**
     * 查询一篇文章
     */
    public Article queryArticleById(Integer id);

    /**
     * 查询文章数量
     */
    public Integer queryCount(String username);
}

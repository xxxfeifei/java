package com.blog.javabean;

public class Article {
    private Integer id;
    private String title;
    private String main;
    private String username;

    public Article(Integer id, String title, String main, String username) {
        this.id = id;
        this.title = title;
        this.main = main;
        this.username = username;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", main='" + main + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}

package com.example.dean.newsapp;

public class News {
    private String title;
    private String section;
    private String author;
    private String datePublished;
    private String webUrl;

    public News(String title, String section) {
        this.title = title;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getAuthor() {
        return author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getWebUrl() {
        return webUrl;
    }
}

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

    public News(String title, String section, String datePublished, String webUrl) {
        this.title = title;
        this.section = section;
        this.datePublished = datePublished;
        this.webUrl = webUrl;
    }

    public News(String title, String section, String datePublished, String webUrl, String author) {
        this.title = title;
        this.section = section;
        this.datePublished = datePublished;
        this.webUrl = webUrl;
        this.author = author;
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

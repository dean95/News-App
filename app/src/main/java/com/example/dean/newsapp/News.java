package com.example.dean.newsapp;

public class News {
    private String title;
    private String section;
    private String datePublished;
    private String webUrl;

    public News(String title, String section, String datePublished, String webUrl) {
        this.title = title;
        this.section = section;
        this.datePublished = datePublished;
        this.webUrl = webUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getWebUrl() {
        return webUrl;
    }
}

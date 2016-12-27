package com.example.dean.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ArrayList<News> news = new ArrayList<>();
        news.add(new News("The tech winners and losers of 2016 (hint: Facebook – and Facebook)", "Technology"));
        news.add(new News("Facebook copies Snapchat feature for 15th time", "Technology"));
        news.add(new News("Facebook break can boost wellbeing, study suggests", "Technology"));

        ListView newsListView = (ListView) findViewById(R.id.list);

        NewsAdapter adapter = new NewsAdapter(this, news);

        newsListView.setAdapter(adapter);
    }
}

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

        ListView newsListView = (ListView) findViewById(R.id.list);

        ArrayList<News> news = QueryUtils.extractNews();

        NewsAdapter adapter = new NewsAdapter(this, news);

        newsListView.setAdapter(adapter);
    }
}

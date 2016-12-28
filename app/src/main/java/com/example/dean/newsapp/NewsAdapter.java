package com.example.dean.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentNews.getSection());

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formatDate(currentNews.getDatePublished()));

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(formatTime(currentNews.getDatePublished()));

        return listItemView;
    }

    private static String formatDate(String data) {
        String date = getDate(data);
        DateFormat input = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date dateObj = null;
        try {
            dateObj = input.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat output = new SimpleDateFormat("LLL dd, yyyy", Locale.ENGLISH);

        return output.format(dateObj);
    }

    private static String formatTime(String data) {
        String time = getTime(data);
        DateFormat input = new SimpleDateFormat("hh:MM:ss", Locale.ENGLISH);
        Date dateObj = null;
        try {
            dateObj = input.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat output = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        return output.format(dateObj);
    }

    private static String getDate(String data) {
        String date = null;
        if(data.contains("T") && data.contains("Z")) {
            String[] parts = data.split("T|Z");
            date = parts[0];
        }
        return date;
    }

    private static String getTime(String data) {
        String time = null;
        if(data.contains("T") && data.contains("Z")) {
            String[] parts = data.split("T|Z");
            time = parts[1];
        }
        return time;
    }
}

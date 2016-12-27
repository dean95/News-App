package com.example.dean.newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {
    private static final String JSON_SAMPLE = "{\n" +
            "  \"response\": {\n" +
            "    \"status\": \"ok\",\n" +
            "    \"userTier\": \"developer\",\n" +
            "    \"total\": 47378,\n" +
            "    \"startIndex\": 1,\n" +
            "    \"pageSize\": 10,\n" +
            "    \"currentPage\": 1,\n" +
            "    \"pages\": 4738,\n" +
            "    \"orderBy\": \"relevance\",\n" +
            "    \"results\": [\n" +
            "      {\n" +
            "        \"id\": \"technology/2016/dec/20/2016-tech-winners-losers-facebook-peter-thiel\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"technology\",\n" +
            "        \"sectionName\": \"Technology\",\n" +
            "        \"webPublicationDate\": \"2016-12-20T08:00:43Z\",\n" +
            "        \"webTitle\": \"The tech winners and losers of 2016 (hint: Facebook – and Facebook)\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/technology/2016/dec/20/2016-tech-winners-losers-facebook-peter-thiel\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/technology/2016/dec/20/2016-tech-winners-losers-facebook-peter-thiel\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"technology/2016/dec/16/facebook-copies-snapchat-feature-for-15th-time\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"technology\",\n" +
            "        \"sectionName\": \"Technology\",\n" +
            "        \"webPublicationDate\": \"2016-12-16T09:44:23Z\",\n" +
            "        \"webTitle\": \"Facebook copies Snapchat feature for 15th time\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/technology/2016/dec/16/facebook-copies-snapchat-feature-for-15th-time\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/technology/2016/dec/16/facebook-copies-snapchat-feature-for-15th-time\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"technology/2016/dec/22/facebook-break-can-boost-wellbeing-study-suggests\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"technology\",\n" +
            "        \"sectionName\": \"Technology\",\n" +
            "        \"webPublicationDate\": \"2016-12-22T10:55:14Z\",\n" +
            "        \"webTitle\": \"Facebook break can boost wellbeing, study suggests\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/technology/2016/dec/22/facebook-break-can-boost-wellbeing-study-suggests\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/technology/2016/dec/22/facebook-break-can-boost-wellbeing-study-suggests\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"media/2016/dec/12/facebook-an-antidote-to-mainstream-media\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"media\",\n" +
            "        \"sectionName\": \"Media\",\n" +
            "        \"webPublicationDate\": \"2016-12-12T19:47:18Z\",\n" +
            "        \"webTitle\": \"Facebook an antidote to mainstream media | Letters\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/media/2016/dec/12/facebook-an-antidote-to-mainstream-media\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/media/2016/dec/12/facebook-an-antidote-to-mainstream-media\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"tv-and-radio/tvandradioblog/2016/oct/13/facebook-live-hosts-ground-breaking-interactive-mystery\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"tv-and-radio\",\n" +
            "        \"sectionName\": \"Television & radio\",\n" +
            "        \"webPublicationDate\": \"2016-10-13T10:31:39Z\",\n" +
            "        \"webTitle\": \"Facebook Live hosts groundbreaking interactive murder mystery\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/tv-and-radio/tvandradioblog/2016/oct/13/facebook-live-hosts-ground-breaking-interactive-mystery\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/tv-and-radio/tvandradioblog/2016/oct/13/facebook-live-hosts-ground-breaking-interactive-mystery\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"technology/2016/oct/12/facebook-censors-le-monde-mammogram-screening-photo-breast-anti-nipple-policy\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"technology\",\n" +
            "        \"sectionName\": \"Technology\",\n" +
            "        \"webPublicationDate\": \"2016-10-12T08:51:23Z\",\n" +
            "        \"webTitle\": \"Facebook censors Le Monde's mammogram screening photo\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/technology/2016/oct/12/facebook-censors-le-monde-mammogram-screening-photo-breast-anti-nipple-policy\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/technology/2016/oct/12/facebook-censors-le-monde-mammogram-screening-photo-breast-anti-nipple-policy\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"technology/2016/oct/09/facebook-revenge-pornography-case-could-open-floodgates\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"technology\",\n" +
            "        \"sectionName\": \"Technology\",\n" +
            "        \"webPublicationDate\": \"2016-10-09T14:21:10Z\",\n" +
            "        \"webTitle\": \"Facebook revenge pornography trial 'could open floodgates'\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/technology/2016/oct/09/facebook-revenge-pornography-case-could-open-floodgates\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/technology/2016/oct/09/facebook-revenge-pornography-case-could-open-floodgates\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"media/2016/dec/23/strictly-power-spike-press-regulation-facebook-break\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"media\",\n" +
            "        \"sectionName\": \"Media\",\n" +
            "        \"webPublicationDate\": \"2016-12-23T09:09:39Z\",\n" +
            "        \"webTitle\": \"Strictly power spike, press regulation and taking a Facebook break\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/media/2016/dec/23/strictly-power-spike-press-regulation-facebook-break\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/media/2016/dec/23/strictly-power-spike-press-regulation-facebook-break\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"media/2016/dec/21/murdoch-faces-scrutiny-bbc1-tops-ratings-and-eu-charges-facebook\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"media\",\n" +
            "        \"sectionName\": \"Media\",\n" +
            "        \"webPublicationDate\": \"2016-12-21T10:01:00Z\",\n" +
            "        \"webTitle\": \"Murdoch faces scrutiny, BBC1 tops ratings and EU charges Facebook\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/media/2016/dec/21/murdoch-faces-scrutiny-bbc1-tops-ratings-and-eu-charges-facebook\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/media/2016/dec/21/murdoch-faces-scrutiny-bbc1-tops-ratings-and-eu-charges-facebook\",\n" +
            "        \"isHosted\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"technology/2016/dec/20/eu-facebook-misleading-information-whatsapp\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"technology\",\n" +
            "        \"sectionName\": \"Technology\",\n" +
            "        \"webPublicationDate\": \"2016-12-20T14:39:07Z\",\n" +
            "        \"webTitle\": \"EU charges Facebook with giving 'misleading' information over WhatsApp\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/technology/2016/dec/20/eu-facebook-misleading-information-whatsapp\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/technology/2016/dec/20/eu-facebook-misleading-information-whatsapp\",\n" +
            "        \"isHosted\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    private QueryUtils() {

    }

    public static ArrayList<News> extractNews() {
        ArrayList<News> newsList = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(JSON_SAMPLE);

            JSONObject response = root.getJSONObject("response");

            JSONArray results = response.getJSONArray("results");

            for(int i = 0; i < results.length(); i++) {
                JSONObject currentNews = results.getJSONObject(i);

                String sectionName = currentNews.getString("sectionName");
                String webTitle = currentNews.getString("webTitle");
                String webPublicationDate = currentNews.getString("webPublicationDate");
                String webUrl = currentNews.getString("webUrl");

                News news = new News(webTitle, sectionName, webPublicationDate, webUrl);

                newsList.add(news);
            }
        } catch(JSONException e) {
            Log.e("QueryUtils", "Problem parsing earthquake JSON result", e);
        }
        return newsList;
    }
}

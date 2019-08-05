package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Tweet {
    //empty constructor for parcel
    public Tweet() {
    }

    public String body;
    public long uid;
    public String createdAt;
    public String media_url;
    public User user;


    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt=jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        //tweet.media_url=jsonObject.getJSONArray("media").getJSONObject(0).getString("media_url");

        return tweet;
    }

    public static String getFormattedTimestamp(String createdAt)
    {
        return TimeFormatter.getTimeDifference(createdAt);
    }

}

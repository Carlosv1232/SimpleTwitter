package com.codepath.apps.restclienttemplate.models;

import android.hardware.usb.UsbRequest;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
@Entity
public class User {

    @ColumnInfo
    @PrimaryKey
    public long id;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public String screenName;

    @ColumnInfo
    public String publicImageUrl;

    //empty constructor needed by the parceler library
    public User(){}

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.id = jsonObject.getLong("id");
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.publicImageUrl = jsonObject.getString("profile_image_url_https");
        return user;
    }

    public static List<User> fromJsonTweetArray(List<Tweet> tweetFromNetwork) {
        List<User> users= new ArrayList<>();
        for(int i = 0; i < tweetFromNetwork.size(); i++){

             users.add(tweetFromNetwork.get(i).user);
        }
        return users;
    }
}

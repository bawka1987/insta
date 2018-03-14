package com.bawka.Service;

import com.bawka.Model.Picture;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;

public class JsonParser {


    public static ArrayList<Picture> getMediaByHashTag(String json)
    {
        ArrayList<Picture>result = new ArrayList<Picture>();
        String media_url;
        JSONObject object = (JSONObject) JSONValue.parse(json);
        JSONArray jsonArray = (JSONArray)object.get("data");
        for(int i=0;i<jsonArray.size();i++)
        {
            Picture picture = new Picture();
            object = (JSONObject)jsonArray.get(i);
            picture.setId(object.get("id").toString());
            object = (JSONObject)object.get("images");
            object = (JSONObject)object.get("thumbnail");
            //System.out.println(object.get("url"));
            //object = (JSONObject)object.get("url");
            picture.setUrl(object.get("url").toString());
           // System.out.println(i+" "+media_url);
            result.add(picture);
            //
            //System.out.println(media_url);
        }
        return result;
    }
    public static String getUserName(String json)
    {
        String result = "";
        JSONObject object = (JSONObject)JSONValue.parse(json);
        object = (JSONObject)object.get("data");
        result = object.get("username").toString();
        return result;
    }
    public static  String getUserPic(String json)
    {
        String result = "";
        JSONObject object = (JSONObject)JSONValue.parse(json);
        object = (JSONObject)object.get("data");
        result = object.get("profile_picture").toString();
        return result;
    }
}

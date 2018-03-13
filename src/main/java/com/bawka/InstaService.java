package com.bawka;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.bawka.Util.CLIENT_ID;
import static com.bawka.Util.CLIENT_SECRET;
import static com.bawka.Util.REDIRECT_URI;

public class InstaService {
    //public static  String TOKEN = "261217117.37586ab.345925a65d824e388038fd901bcb5efc"; //TEMPORARY
    HttpClient client = HttpClients.createDefault();
    HttpEntity entity = null;
    HttpResponse response = null;
    public static String getAuthUrl()
    {
       return  "https://api.instagram.com/oauth/authorize/?client_id="+ CLIENT_ID+"&redirect_uri="+ REDIRECT_URI+"&response_type=code"+"&scope=basic+public_content";

    }
    public String getTokenRequest(String secret)
    {
        String json = null;
        HttpPost post = new HttpPost("https://api.instagram.com/oauth/access_token");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("client_id",CLIENT_ID));
        params.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
        params.add(new BasicNameValuePair("redirect_uri", REDIRECT_URI));
        params.add(new BasicNameValuePair("grant_type", "authorization_code"));
        params.add(new BasicNameValuePair("code", secret));
       try {
           post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
           response = client.execute(post);
           entity = response.getEntity();
       }
       catch (UnsupportedEncodingException ex){ex.printStackTrace();}
       catch (IOException ex){ex.printStackTrace();}

        if (entity!=null)
        {
            InputStream inputStream = null;
            BufferedReader reader = null;
            try {
                inputStream = entity.getContent();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                json = reader.readLine();
                reader.close();
            }
            catch (Exception ex){ex.printStackTrace();}

            }



        return json;
        }
        public String getUser(String token)
        {
            String json = null;
            HttpGet request = new HttpGet("https://api.instagram.com/v1/users/self/?access_token="+token);
            try{
                response = client.execute(request);
                entity = response.getEntity();
            }
            catch (IOException ex){ex.printStackTrace();}


            if (entity!=null)
            {
                try{
                     BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                     json = reader.readLine();
                     reader.close();
                }
                catch (Exception ex){ex.printStackTrace();}
            }
            return json;
        }
        public String getMediaByHashTag(String tagname,String token)
        {
            String json = null;
            String count = "20";
            HttpGet request = new HttpGet("https://api.instagram.com/v1/tags/"+tagname+"/media/recent?access_token="+token+"&count="+count);
            //System.out.println(request);
            try{
                response = client.execute(request);
                entity = response.getEntity();
            }
            catch (IOException ex){ex.printStackTrace();}
            if (entity!=null)
            {
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                    json = reader.readLine();
                    reader.close();
                }
                catch (IOException ex){ex.printStackTrace();}
            }
            return json;
        }

    }


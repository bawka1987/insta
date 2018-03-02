package com.bawka.Servlet;

import com.bawka.InstaService;
import com.bawka.Service.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/profile/")
public class Profile extends HttpServlet {
    InstaService insta = new InstaService();
    UserService userService= new UserService();
    String html = "";
    String json = null;
    String username = null;
    String userpic = null;
    String token="";
    ArrayList<String>userHashtags = null;
    int uid;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("uid")!=null)
        {
            try{
                uid = (Integer)req.getSession().getAttribute("uid");
                userHashtags = userService.getUserHashtags(uid);
                token = userService.getToken(uid);
                json = insta.getUser(token);
                JSONObject jsonObject = (JSONObject)JSONValue.parse(json);
                jsonObject = (JSONObject)jsonObject.get("data");
                //System.out.println(jsonObject.get("full_name").toString());
                //System.out.println(jsonObject.get("profile_picture"));
                username = jsonObject.get("username").toString();
                userpic = jsonObject.get("profile_picture").toString();
            }
            catch (Exception ex){ex.printStackTrace();}
            json = insta.getMediaByHashTag("крафтэтовойна",token);
            //JSONObject jsonObject = new JSONObject(json);
            //jsonObject.entrySet().toArray()[0].toString();
            resp.getWriter().write(json);
            //getProfile();
           //resp.getWriter().write(html);
        }
        else resp.sendRedirect("/login/");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    private void getProfile()
    {
        html = "<html>"
                +"<head>"
                +"<title>PROFILE</title>"
                +"</head>"
                +"<body>"
                +"<h1>"+username+"</h1>"
                +"<img  src=\""+ userpic+"\">"
                +getHashtagblock(userHashtags)
                +"<a href=\"/logout/\">logout</a>"
                +"</body>"
                +"</html>";
        //return html;
    }
    private String getHashtagblock(ArrayList<String> userHashtags)
    {
        String line="";
        for (String hashtag:userHashtags
             ) {
            //System.out.println(hashtag);
            line+="<div class=\"hashtag\"><a href=\"#\">#"+hashtag+" </a><div>";
        }
        //System.out.println(line);
        return line;
    }
    private String getMediaByHashtag(String hashtag)
    {
        html = "<html>"
                +"<head>"
                +"<title>PROFILE</title>"
                +"</head>"
                +"<body>"
                +"<h1>"+username+"</h1>"
                +"<img  src=\""+ userpic+"\">"
                +getHashtagblock(userHashtags)
                +"<a href=\"/logout/\">logout</a>"
                +"</body>"
                +"</html>";
        return html;
    }

}

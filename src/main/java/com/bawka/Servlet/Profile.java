package com.bawka.Servlet;

import com.bawka.InstaService;
import com.bawka.Service.JsonParser;
import com.bawka.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/profile/*")
public class Profile extends HttpServlet {
    InstaService insta = new InstaService();
    UserService userService= new UserService();
    String html = "";
    String json = null;
    String username = null;
    String userpic = null;
    String token="";
    ArrayList<String>userHashtags = null;
    ArrayList<String>images = null;
    String hashtag = null;
    Long uid;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("uid")!=null)
        {
            try{
                uid = (Long)req.getSession().getAttribute("uid");
                userHashtags = userService.getUserHashtags(uid);
                token = userService.getToken(uid);
                json = insta.getUser(token);
                username = JsonParser.getUserName(json);
                userpic = JsonParser.getUserPic(json);
            }
            catch (Exception ex){ex.printStackTrace();}
            try{
                hashtag = req.getParameter("tagname");
            }
            catch (NullPointerException ex){ex.printStackTrace();}

            try{
                if (hashtag!=null)
                {
                    images = JsonParser.getMediaByHashTag(insta.getMediaByHashTag(hashtag,token));
                    html = "<html>"
                            +"<head>"
                            +"<title>PROFILE</title>"
                            +"</head>"
                            +"<body>"
                            +getHashMediaBlock(images)
                            +"<a href=\"/logout/\">logout</a>"
                            +"</body>"
                            +"</html>";
                    resp.getWriter().write(html);
                }
                else {
                   // json = insta.getMediaByHashTag("testtag",token);
                    getProfile();
                    resp.getWriter().write(html);
                }
            }
            catch (NullPointerException ex){ex.printStackTrace();}




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
                +"<br/>"
                //+getHashMediaBlock(images)
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
            line+="<div class=\"hashtag\"><a href=\"/profile?tagname="+hashtag+"\">#"+hashtag+" </a></div>";
        }
        return line;
    }
    private String getHashMediaBlock(ArrayList<String>imglist)
    {
        String line = "";
        for (String img:imglist
             ) {
            line+="<div class=\"image\"><img src=\""+img+"\"></img> </div>";
        }
        return line;
    }



}

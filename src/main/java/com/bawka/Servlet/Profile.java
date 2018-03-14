package com.bawka.Servlet;

import com.bawka.InstaService;
import com.bawka.Model.Picture;
import com.bawka.Service.JsonParser;
import com.bawka.Service.PicService;
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
    PicService picService = new PicService();
    String html = "";
    String json = null;
    String username = null;
    String userpic = null;
    String token="";
    ArrayList<String>userHashtags = null;
    ArrayList<Picture>images = null;
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
                hashtag = req.getParameter("tagname"); //Проверяем, есть ли парамер hashtag
            }
            catch (NullPointerException ex){ex.printStackTrace();}

            try{
                if (hashtag!=null) //Если хэштэг указан - рисуем картинки
                {
                    //renderMediaByHashtag();
                    //resp.getWriter().write(html);
                    getMedaiByHashtag();
                    req.setAttribute("images",images);
                    req.getRequestDispatcher("/test.jsp").forward(req,resp);
                }
                else {
                   // json = insta.getMediaByHashTag("testtag",token);
                    getProfile();
                    resp.getWriter().write(html);
                }
            }
            catch (NullPointerException ex){
                System.err.println("hashtag is NULL");
            }




        }
        else resp.sendRedirect("/login/");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    private void getProfile() //PROFILE/*
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
    }
    private String getHashtagblock(ArrayList<String> userHashtags) //РЕНДЕР ОБЛАКА ХЭШТЕГОВ
    {
        String line="";
        for (String hashtag:userHashtags
             ) {
            line+="<div class=\"hashtag\"><a href=\"/profile?tagname="+hashtag+"\">#"+hashtag+" </a></div>";
        }
        return line;
    }
    private String getHashMediaBlock(ArrayList<Picture>imglist) //РЭНДЕР БЛОКОВ С КАРТИНКАМИ
    {
        String line = "";
        for (Picture pic:imglist
             ) {
            line+="<div class=\"image\"><img src=\""+pic.getUrl()+"\"></img> </div>";
        }
        return line;
    }
    private void renderMediaByHashtag()
    {
        //images = JsonParser.getMediaByHashTag(insta.getMediaByHashTag(hashtag,token));
        images = picService.getPic(hashtag);
        html = "<html>"
                +"<head>"
                +"<title>"+hashtag+"</title>"
                +"</head>"
                +"<body>"
                +getHashMediaBlock(images)
                +"<a href=\"/logout/\">logout</a>"
                +"</body>"
                +"</html>";
    }
    private void getMedaiByHashtag()
    {
        images = picService.getPic(hashtag);
    }



}

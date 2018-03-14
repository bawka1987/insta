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

@WebServlet("/profile/refresh/")
public class Refresh extends HttpServlet {
    InstaService insta = new InstaService();
    UserService userService= new UserService();
    PicService picService  = new PicService();
    String html = "";
    String json = null;
    String username = null;
    String userpic = null;
    String token="";
    ArrayList<String> userHashtags = null;
    ArrayList<Picture>images = null;
    String hashtag = null;
    Long uid;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("uid")!=null)
        {
            try{
                if (req.getParameter("hashtag")!=null)
                {
                    try{
                        uid = (Long)req.getSession().getAttribute("uid");
                        userHashtags = userService.getUserHashtags(uid);
                        token = userService.getToken(uid);
                        hashtag = req.getParameter("hashtag");
                        images =JsonParser.getMediaByHashTag(insta.getMediaByHashTag(hashtag,token));
                        for (Picture pic:images
                                ) {
                            if (picService.picExist(pic.getId()))
                            {

                            }
                            else
                            {
                                picService.add(pic.getId(),pic.getUrl(),hashtag);
                                resp.getWriter().write("<img src=\""+pic.getUrl()+"\"</img><br/>");
                            }

                        }
                    }
                    catch (Exception ex){ex.printStackTrace();}
                }
                else {
                    resp.getWriter().write("no hashtag provided");
                }
            }
            catch (NullPointerException ex){
                System.err.println("не указан хэштэг");
            }







        }
        else resp.sendRedirect("/login/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

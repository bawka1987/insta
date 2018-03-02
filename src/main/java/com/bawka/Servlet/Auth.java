package com.bawka.Servlet;

import com.bawka.InstaService;
import com.bawka.Service.UserService;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/*")
public class Auth extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
if (req.getSession().getAttribute("uid")==null) authorize(req,resp);
else  resp.sendRedirect("/profile/");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    void authorize(HttpServletRequest req, HttpServletResponse resp){
        UserService userService = new UserService();
        String token=null;
        int user_id=-1;
        String code = req.getParameter("code");
        InstaService insta = new InstaService();
        String json = insta.getTokenRequest(code);
        JSONObject jsonObject = (JSONObject) JSONValue.parse(json);
        try
        {
            token = jsonObject.get("access_token").toString();
            json=insta.getUser(token);
            jsonObject = (JSONObject)JSONValue.parse(json);
            jsonObject = (JSONObject)jsonObject.get("data");
            user_id = Integer.parseInt(jsonObject.get("id").toString());
            req.getSession().setAttribute("uid",user_id);
            //System.out.println("uid:"+req.getSession().getAttribute("uid"));
        }
        catch (NullPointerException ex){//ex.printStackTrace();
            System.out.println("JSON PARSE ERROR"); }

        //System.out.println(user_id);
        if (user_id==-1)
        {
            System.out.println("USERID IS INVALID");
            try{
                resp.sendRedirect("/login/");
            }
            catch (IOException ex){ex.printStackTrace();}

        }
        else
        {
            if (!userService.userExist(user_id))
            {
                userService.userAdd(user_id,token);
                System.out.println("USER "+user_id+" CREATED");
            }
            else {
                System.out.println("USER "+user_id+" ALREADY EXIST - REDIRECT TO PROFILE");
                userService.updateToken(user_id,token);
                System.out.println("TOKEN UPDATED");
            }
            try
            {
                resp.sendRedirect("/profile/");
            }
            catch (IOException ex){ex.printStackTrace();}

        }

        //System.out.println(jsonObject.get("access_token").toString());
    }
    String getUser(String token) throws Exception
    {
        InstaService insta = new InstaService();
        String json = insta.getUser(token);
        return json;
    }

}

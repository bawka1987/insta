package com.bawka.Servlet;

import com.bawka.InstaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/")
public class Login extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
if (req.getSession().getAttribute("uid")==null)
{
    String html = "<html>"
            +"<head>"
            +"<title>LOGIN PAGE</title>"
            +"</head>"
            +"<body>"
            +"<a href=\""+ InstaService.getAuthUrl()+"\"> login</a>"
            +"</body>"
            +"</html>";
    resp.getWriter().write(html);
}
    else resp.sendRedirect("/profile/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

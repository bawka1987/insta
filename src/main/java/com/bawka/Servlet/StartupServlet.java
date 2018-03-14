package com.bawka.Servlet;


import org.apache.velocity.app.Velocity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import static com.bawka.Util.RESOURCE_DIR;

public class StartupServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Properties props = new Properties();
        props.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "C:\\WEBSERVER\\apache-tomcat-9.0.4\\webapps\\ROOT"+RESOURCE_DIR);
        Velocity.init(props);
        System.out.println("SERVLET INITIALIZED!!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login/");
    }
}

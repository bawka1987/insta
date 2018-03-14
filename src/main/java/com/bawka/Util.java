package com.bawka;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.http.HttpServlet;

public class Util {
    private static final String base = "insta";
    private static final String url = "jdbc:mysql://localhost:3306/"+base+"?useUnicode=true&amp;characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String pass = "root";
	static final String CLIENT_ID = "37586ab40450459aabbf54d2fef526cc";
    static final String REDIRECT_URI = "http://localhost:8080/auth/";
    static final  String CLIENT_SECRET = "f7cfdd09c70e4f3893b5b0ae2bb47520";
    public static final String RESOURCE_DIR = "/WEB-INF/templates/";

    public Connection getConnection()
    {
        Connection connection=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
            //System.out.println("OK");
        }
        catch (Exception ex){ex.printStackTrace();}
        return connection;
    }

    public static void servletVelocityRender(VelocityContext context, String templateName, HttpServletResponse resp) throws IOException
    {
        String result="";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Template template = Velocity.getTemplate(templateName,"utf-8");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream));
        template.merge(context,bw);
        bw.flush();
        bw.close();
        result = byteArrayOutputStream.toString();
        System.out.println(result);
        byteArrayOutputStream.reset();
        byteArrayOutputStream.close();
        resp.getWriter().write(result);
    }
}

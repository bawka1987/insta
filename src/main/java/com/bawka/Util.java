package com.bawka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String base = "insta";
    private static final String url = "jdbc:mysql://localhost:3306/"+base+"?useUnicode=true&amp;characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String pass = "root";
	static final String CLIENT_ID = "37586ab40450459aabbf54d2fef526cc";
    static final String REDIRECT_URI = "http://localhost:8080/auth/";
    static final  String CLIENT_SECRET = "f7cfdd09c70e4f3893b5b0ae2bb47520";

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
}

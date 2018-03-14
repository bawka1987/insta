package com.bawka.Service;

import com.bawka.Model.Picture;
import com.bawka.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PicService extends Util {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public boolean picExist(String id)
    {
        boolean flag=false;
        connection = getConnection();
        ResultSet resultSet = null;
        String query = "select * from pictures where id=?";
        try
        {
            statement = connection.prepareStatement(query);
            statement.setString(1,id);
            resultSet=statement.executeQuery();
            flag=resultSet.next();
        }
        catch (SQLException ex){ex.printStackTrace();}
        finally {
            try
            {
                statement.close();
                connection.close();
            }
            catch (SQLException ex){ex.printStackTrace();}
        }
        return flag;
    }
    public void add(String id, String url,String hashtag)
    {
        connection = getConnection();
        String query = "insert into pictures (id,url,hashtag) values (?,?,?)";
        try
        {
            statement = connection.prepareStatement(query);
            statement.setString(1,id);
            statement.setString(2,url);
            statement.setString(3,hashtag);
            statement.execute();
        }
        catch (SQLException ex){ex.printStackTrace();}
        finally {
            try{
                statement.close();
                connection.close();
            }
            catch (SQLException ex){ex.printStackTrace();}
        }
    }
public ArrayList<Picture> getPic(String hashtag)
{
    ArrayList<Picture>result = new ArrayList<Picture>();

    connection = getConnection();
    String query = "select * from pictures WHERE hashtag=? order by id desc limit 5";
    try
    {
        statement = connection.prepareStatement(query);
        statement.setString(1,hashtag);
        resultSet = statement.executeQuery();
        while (resultSet.next())
        {
            Picture picture = new Picture();
            picture.setId(resultSet.getString(1));
            picture.setUrl(resultSet.getString(2));
            picture.setHashtag(resultSet.getString(3));
            result.add(picture);
        }
    }
    catch (SQLException ex){ex.printStackTrace();}
    finally {
        try{
            statement.close();
            connection.close();
        }
        catch (SQLException ex){ex.printStackTrace();}
    }
    return result;
}
}

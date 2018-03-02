package com.bawka.Service;

import com.bawka.DAO.UserDAO;
import com.bawka.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService extends Util implements UserDAO {
Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
    public boolean userExist(int id) {
        boolean flag=false;
        connection = getConnection();
        ResultSet resultSet = null;
        String query = "select * from users where id=?";
        try
        {
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
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

    public void userAdd(int id, String token) {
        connection = getConnection();
        String query = "insert into users (id,token) values (?,?)";
        try
        {
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.setString(2,token);
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
    public String getToken(int id)
    {
        connection = getConnection();
        String query = "select * from insta.users where id=?";
        String token = "";
        try
        {
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            //System.out.println(id);
            while (resultSet.next())
            {
                token = resultSet.getString(2);
            }

        }
        catch (SQLException ex){ex.printStackTrace();}
        finally {
            try {
                statement.close();
                connection.close();
            }
            catch (SQLException ex){ex.printStackTrace();}
        }
        return token;
    }
    public void updateToken(int id,String token)
    {
        connection = getConnection();
        String query = "update users set token=? where id=?";
        try{
            statement = connection.prepareStatement(query);
            statement.setString(1,token);
            statement.setInt(2,id);
            statement.execute();
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
    }
    public ArrayList<String>getUserHashtags(int id)
    {
        ArrayList<String>userHashtags = new ArrayList<String>();
        connection = getConnection();
        String query = "select tag from tags_users where id=?";
        try
        {
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                userHashtags.add(resultSet.getString("tag"));
            }
        }
        catch (SQLException ex){ex.printStackTrace();}
        return userHashtags;
    }
}

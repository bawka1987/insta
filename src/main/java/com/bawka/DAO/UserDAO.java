package com.bawka.DAO;


public interface UserDAO {
    boolean userExist(int id);
    void userAdd(int id, String token);
}

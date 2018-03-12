package com.bawka.DAO;


public interface UserDAO {
    boolean userExist(Long id);
    void userAdd(Long id, String token);
}

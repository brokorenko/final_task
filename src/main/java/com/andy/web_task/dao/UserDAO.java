package com.andy.web_task.dao;

import com.andy.web_task.dao.exception.DAOException;

public interface UserDAO {
    boolean checkPassword(String name, String checkingPassword) throws DAOException;

    void registerUser(String username, String password) throws DAOException;
}

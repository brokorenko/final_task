package com.andy.web_task.service;

import com.andy.web_task.service.exception.ServiceException;

public interface UserService {

    boolean checkPassword(String name, String checkingPassword) throws ServiceException;

    void registerUser(String username, String password) throws ServiceException;

}

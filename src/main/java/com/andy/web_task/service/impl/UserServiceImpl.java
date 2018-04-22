package com.andy.web_task.service.impl;

import com.andy.web_task.dao.UserDAO;
import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.dao.impl.UserDAOImpl;
import com.andy.web_task.service.UserService;
import com.andy.web_task.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean checkPassword(String name, String checkingPassword) throws ServiceException {
        try {
            return userDAO.checkPassword(name, checkingPassword);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void registerUser(String username, String password) throws ServiceException {
        try {
            userDAO.registerUser(username, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}

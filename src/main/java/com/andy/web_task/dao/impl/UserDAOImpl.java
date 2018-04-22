package com.andy.web_task.dao.impl;

import com.andy.web_task.dao.UserDAO;
import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.dao.connection_pool.DataSource;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    private static final String CHECK_USER = "SELECT password FROM user WHERE name = ?";
    private static final String REGISTER_USER = "INSERT INTO `user` (`id`, `name`, `password`) VALUES (NULL, ?, ?);";

    @Override
    public boolean checkPassword(String name, String checkingPassword) throws DAOException {

        Connection connection = null;
        String password = "";

        try {

            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(CHECK_USER);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return password.equals(getMd5Hex(checkingPassword));
    }

    @Override
    public void registerUser(String username, String password) throws DAOException {
        Connection connection = null;

        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(REGISTER_USER);
            statement.setString(1, username);
            statement.setString(2, getMd5Hex(password));

            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    private String getMd5Hex(String password) {
        return DigestUtils.md5Hex(password);
    }
}


package com.andy.web_task.dao.impl;

import com.andy.web_task.controller.command.CompanyType;
import com.andy.web_task.dao.CompanyDAO;
import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.dao.connection_pool.DataSource;
import com.andy.web_task.entity.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {

    private static final String ALL_COMPANIES = "SELECT * FROM company LIMIT ?, ?";
    private static final String COMPANIES_BY_TYPE = "SELECT * FROM company WHERE company.type_id = (SELECT type.id FROM type WHERE type.name = ?) LIMIT ?, ?";
    private static final String USER_COMPANIES = "SELECT * FROM `company` WHERE company.user_id = (SELECT user.id FROM user WHERE user.name = ?) LIMIT  ?, ?";


    private static final String ALL_COMPANIES_PAGE_COUNT = "SELECT COUNT(1) FROM company";
    private static final String COMPANIES_BY_TYPE_PAGE_COUNT = "SELECT COUNT(1) FROM company WHERE company.type_id = (SELECT type.id FROM type WHERE type.name = ?)";
    private static final String USER_COMPANIES_PAGE_COUNT = "SELECT COUNT(1) FROM company WHERE company.user_id = (SELECT user.id FROM user WHERE user.name = ?)";

    private static final String CONCREATE_COMPANY = "SELECT * FROM company WHERE company.id = ?";

    private static final String DELETE_COMPANY_BY_ID = "DELETE FROM company WHERE company.id = ?";
    private static final String EDIT_COMPANY_BY_ID = "UPDATE `company` SET `name`= ?,`service_list`= ? WHERE company.id = ?";
    private static final String ADD_COMPANY = "INSERT INTO `company` (`id`, `name`, `service_list`, `rate`, `type_id`, `user_id`) VALUES (NULL, ?, ?, 0, ?, ?);";

    @Override
    public List<Company> getAllCompanies(int startElement, int count) throws DAOException {
        List<Company> companies = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(ALL_COMPANIES);
            statement.setInt(1, startElement);
            statement.setInt(2, startElement + count);
            rs = statement.executeQuery();
            companies = new ArrayList<>();

            while (rs.next()){
                Company company = new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setServiceList(rs.getString(3));
                company.setRate(rs.getInt(4));
                company.setTypeId(rs.getInt(5));
                company.setUserId(rs.getInt(6));
                companies.add(company);
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage() + "cant get all companies");
        } finally {
            DataSource.returnConnection(connection, statement, rs);
        }

        return companies;
    }

    @Override
    public List<Company> getCompaniesByType(int startElement, int count, CompanyType type) throws DAOException {
        List<Company> companies = null;
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(COMPANIES_BY_TYPE);
            statement.setString(1, type.toString());
            statement.setInt(2, startElement);
            statement.setInt(3, startElement + count);
            ResultSet rs = statement.executeQuery();
            companies = new ArrayList<>();

            while (rs.next()){
                Company company = new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setServiceList(rs.getString(3));
                company.setRate(rs.getInt(4));
                company.setTypeId(rs.getInt(5));
                company.setUserId(rs.getInt(6));
                companies.add(company);
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }

        return companies;
    }

    @Override
    public List<Company> getUserCompanies(int startElement, int count, String username) throws DAOException {
        List<Company> companies = null;
        Connection connection = null;

        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(USER_COMPANIES);
            statement.setString(1, username);
            statement.setInt(2, startElement);
            statement.setInt(3, startElement + count);

            ResultSet rs = statement.executeQuery();
            companies = new ArrayList<>();

            while (rs.next()){
                Company company = new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setServiceList(rs.getString(3));
                company.setRate(rs.getInt(4));
                company.setTypeId(rs.getInt(5));
                company.setUserId(rs.getInt(6));
                companies.add(company);
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }

        return companies;
    }

    @Override
    public int getAllCompaniesPageCount() throws DAOException {
        Connection connection = null;

        try {
            connection = DataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ALL_COMPANIES_PAGE_COUNT);
            if (resultSet.next()) {
                return resultSet.getInt("COUNT(1)")/10;
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }

        return 0;
    }

    @Override
    public int getCompaniesByTypePageCount(CompanyType type) throws DAOException {
        Connection connection = null;

        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(COMPANIES_BY_TYPE_PAGE_COUNT);
            statement.setString(1, type.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("COUNT(1)")/10;
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }

        return 0;
    }

    @Override
    public int getUserCompaniesPageCount(String username) throws DAOException {
        Connection connection = null;

        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(USER_COMPANIES_PAGE_COUNT);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("COUNT(1)")/10;
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }

        return 0;
    }

    @Override
    public Company getCompanyInformation(int companyId) throws DAOException {

        Company company = null;
        Connection connection = null;

        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(CONCREATE_COMPANY);
            statement.setInt(1, companyId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                company = new Company();
                company.setId(rs.getInt(1));
                company.setName(rs.getString(2));
                company.setServiceList(rs.getString(3));
                company.setRate(rs.getInt(4));
                company.setTypeId(rs.getInt(5));
                company.setUserId(rs.getInt(6));

            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
        }
        return company;
    }

    @Override
    public void deleteUserCompany(String username, int companyId) throws DAOException {
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_COMPANY_BY_ID);
            statement.setInt(1, companyId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
        }
    }

    @Override
    public void editUserCompany(String name, String serviceList, int companyId) throws DAOException {
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(EDIT_COMPANY_BY_ID);
            statement.setString(1, name);
            statement.setString(2, serviceList);
            statement.setInt(3, companyId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
        }
    }

    @Override
    public void addCompany(String username, String companyName, String serviceList, String type) throws DAOException {

        Connection connection = null;
        try {
            connection = DataSource.getConnection();

            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT type.id FROM type WHERE type.name = ?");
            preparedStatement1.setString(1, type);
            ResultSet resultSet = preparedStatement1.executeQuery();
            int typeId = 0;
            while (resultSet.next()){
                typeId = resultSet.getInt(1);
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT user.id FROM user WHERE user.name = ?");
            preparedStatement2.setString(1, username);
            resultSet = preparedStatement2.executeQuery();
            int userId = 0;
            while (resultSet.next()){
                userId = resultSet.getInt(1);
            }

            PreparedStatement statement = connection.prepareStatement(ADD_COMPANY);
            statement.setString(1, companyName);
            statement.setString(2, serviceList);
            statement.setInt(3, typeId);
            statement.setInt(4, userId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DAOException(e.getMessage());
                }
            }
        }
    }

}

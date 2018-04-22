package com.andy.web_task.dao.impl;

import com.andy.web_task.dao.FeedbackDAO;
import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.dao.connection_pool.DataSource;
import com.andy.web_task.entity.FeedBack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO {

    private final static String ALL_FEEDBACK = "SELECT * FROM feedback WHERE feedback.company_id = ? AND feedback.id > ? AND feedback.id < ?";
    private static final String FEEDBACK_ELEMENT_COUNT = "SELECT COUNT(1) FROM feedback WHERE feedback.company_id = ?";


    @Override
    public List<FeedBack> getFeedbackList(int startElement, int count, int companyId) {
        return null;
    }

    @Override
    public List<FeedBack> getCompanyFeedbacks(int companyId, int startElement, int ON_PAGE) throws DAOException {
        List<FeedBack> feedBacks = null;
        Connection connection = null;
        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(ALL_FEEDBACK);
            statement.setInt(1, companyId);
            statement.setInt(2, startElement);
            statement.setInt(3, startElement + ON_PAGE);
            ResultSet rs = statement.executeQuery();
            feedBacks = new ArrayList<>();

            while (rs.next()){
                FeedBack feedback = new FeedBack();
                feedback.setId(rs.getInt(1));
                feedback.setCompanyId(rs.getInt(2));
                feedback.setDate(rs.getDate(3));
                feedback.setContent(rs.getString(4));
                feedBacks.add(feedback);
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

        return feedBacks;
    }

    @Override
    public int getFeedbacksPageCount(int companyId) throws DAOException {
        Connection connection = null;

        try {
            connection = DataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(FEEDBACK_ELEMENT_COUNT);
            statement.setInt(1, companyId);
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
}

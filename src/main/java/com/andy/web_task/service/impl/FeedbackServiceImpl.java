package com.andy.web_task.service.impl;

import com.andy.web_task.dao.FeedbackDAO;
import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.dao.impl.FeedbackDAOImpl;
import com.andy.web_task.entity.FeedBack;
import com.andy.web_task.service.FeedbackService;
import com.andy.web_task.service.exception.ServiceException;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackDAO feedbackDAO = new FeedbackDAOImpl();

    @Override
    public List<FeedBack> getCompanyFeedbacks(int companyId, int startElement, int ON_PAGE) throws ServiceException {
        try {
            return feedbackDAO.getCompanyFeedbacks(companyId, startElement, ON_PAGE);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public int getFeedbacksPageCount(int companyId) throws ServiceException {
        try {
            return feedbackDAO.getFeedbacksPageCount(companyId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}

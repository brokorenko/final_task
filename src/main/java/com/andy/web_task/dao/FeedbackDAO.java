package com.andy.web_task.dao;

import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.entity.FeedBack;

import java.util.List;

public interface FeedbackDAO {

    List<FeedBack> getFeedbackList(int startElement, int count, int companyId);

    List<FeedBack> getCompanyFeedbacks(int companyId, int startElement, int ON_PAGE) throws DAOException;

    int getFeedbacksPageCount(int companyId) throws DAOException;
}

package com.andy.web_task.service;

import com.andy.web_task.entity.FeedBack;
import com.andy.web_task.service.exception.ServiceException;

import java.util.List;

public interface FeedbackService {
    List<FeedBack> getCompanyFeedbacks(int companyId, int startElement, int ON_PAGE) throws ServiceException;
    int getFeedbacksPageCount(int companyId) throws ServiceException;
}

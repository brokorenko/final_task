package com.andy.web_task.controller.command;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.FeedbackService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.CompanyServiceImpl;
import com.andy.web_task.service.impl.FeedbackServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CompanyDetailsCommand extends FrontCommand {

    private CompanyService companyService = new CompanyServiceImpl();
    private FeedbackService feedbackService = new FeedbackServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        HttpSession session = request.getSession(true);
        if (request.getParameter("companyId") != null) {
            session.setAttribute("companyId", request.getParameter("companyId"));
        }

        if (request.getParameter("username") != null && session.getAttribute("username") != null){
            request.setAttribute("username", request.getParameter("username"));
        }


        int companyId = Integer.valueOf((String) session.getAttribute("companyId"));

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int startElement = currentPage * ON_PAGE;

        request.setAttribute("company", companyService.getCompanyInformation(companyId));
        request.setAttribute("feedbacks", feedbackService.getCompanyFeedbacks(companyId, startElement, ON_PAGE));
        request.setAttribute("pageCount", feedbackService.getFeedbacksPageCount(companyId));
        forward("view/company_details.jsp");
    }
}

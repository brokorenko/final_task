package com.andy.web_task.controller.command;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteUserCompanyCommand extends FrontCommand {

    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        HttpSession session = request.getSession(true);

        String username = (String) session.getAttribute("username");
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        //int currentPage = (int) request.getAttribute("currentPage");

        companyService.deleteUserCompany(username, companyId);

        senRedirect("FrontController?command=UserPage&currentPage=" + request.getParameter("currentPage"));
    }
}

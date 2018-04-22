package com.andy.web_task.controller.command;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditUserCompanyCommand extends FrontCommand {

    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        HttpSession session = request.getSession(true);
        int companyId = Integer.valueOf(request.getParameter("companyId"));

        String name = request.getParameter("name");
        String serviceList = request.getParameter("serviceList");
        //String currentPage = request.getParameter("currentPage");

        companyService.editUserCompany(name, serviceList, companyId);

        senRedirect("FrontController?command=UserPage&currentPage=" + request.getParameter("currentPage"));
    }
}

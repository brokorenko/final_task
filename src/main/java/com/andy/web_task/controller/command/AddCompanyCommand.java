package com.andy.web_task.controller.command;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCompanyCommand extends FrontCommand {
    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        String username = (String) session.getAttribute("username");

        String companyName = request.getParameter("name");
        String serviceList = request.getParameter("serviceList");
        String type = request.getParameter("type");

        companyService.addCompany(username, companyName, serviceList, type);

        senRedirect("FrontController?command=UserPage&currentPage=0");;
    }
}

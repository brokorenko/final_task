package com.andy.web_task.controller.command;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserPageCommand extends FrontCommand {

    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        if (request.getParameter("locale") != null) {
            session.setAttribute("locale", request.getParameter("locale"));
        }
        request.setAttribute("commandName", "UserPage");

        if (session.getAttribute("authorized") != null) {
            int currentPage = Integer.valueOf(request.getParameter("currentPage"));
            int startElement = currentPage * ON_PAGE;
            String username = (String) session.getAttribute("username");

            request.setAttribute("userCompanyList", companyService.getUserCompanies(startElement, ON_PAGE, username));
            request.setAttribute("pageCount", companyService.getUserPageCount(username));
            request.setAttribute("currentPage", currentPage);
            forward("view/user_page.jsp");
        } else {
            forward("FrontController?command=ShowLoginPage");
        }
    }
}
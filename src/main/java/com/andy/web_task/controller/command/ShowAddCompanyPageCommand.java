package com.andy.web_task.controller.command;

import com.andy.web_task.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShowAddCompanyPageCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException, ServiceException {

        if (request.getParameter("locale") != null) {
            session.setAttribute("locale", request.getParameter("locale"));
        }
        request.setAttribute("commandName", "ShowAddCompanyPage");

        if (session.getAttribute("authorized") != null) {
            forward("/view/add_company_page.jsp");
        } else {
            forward("FrontController?command=ShowLoginPage");
        }
    }
}

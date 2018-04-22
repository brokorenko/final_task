package com.andy.web_task.controller.command;

import com.andy.web_task.service.exception.ServiceException;

import javax.servlet.ServletException;
import java.io.IOException;

public class ShowEditUserCompanyPageCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException, ServiceException {
        if (request.getParameter("locale") != null) {
            session.setAttribute("locale", request.getParameter("locale"));
        }
        request.setAttribute("commandName", "ShowEditUserCompanyPage");
        request.setAttribute("companyId", request.getParameter("companyId"));
        request.setAttribute("currentPage", request.getParameter("currentPage"));
        forward("/view/edit_user_company.jsp");
    }
}

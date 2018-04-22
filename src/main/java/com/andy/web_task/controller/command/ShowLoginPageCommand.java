package com.andy.web_task.controller.command;

import com.andy.web_task.service.exception.ServiceException;

import javax.servlet.ServletException;
import java.io.IOException;

public class ShowLoginPageCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException, ServiceException {
        if (request.getParameter("locale") != null) {
            session.setAttribute("locale", request.getParameter("locale"));
        }
        request.setAttribute("commandName", "ShowLoginPage");
        forward("/view/login_page.jsp");
    }
}

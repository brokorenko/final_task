package com.andy.web_task.controller.command;

import com.andy.web_task.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutUserCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException, ServiceException {
        HttpSession session = request.getSession(true);
        session.removeAttribute("authorized");
        session.removeAttribute("username");
        senRedirect("FrontController?command=FillStartPage&currentPage=0");
    }
}

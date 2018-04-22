package com.andy.web_task.controller.command;

import com.andy.web_task.service.exception.ServiceException;

import javax.servlet.ServletException;
import java.io.IOException;

public class ChangeLocaleCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException, ServiceException {
        senRedirect(request.getParameter("command") + "&currentPage=" + request.getParameter("currentPage"));
    }
}

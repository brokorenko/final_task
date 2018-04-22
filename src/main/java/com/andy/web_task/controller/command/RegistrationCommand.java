package com.andy.web_task.controller.command;

import com.andy.web_task.service.UserService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationCommand extends FrontCommand {

    private UserService userService = new UserServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userService.registerUser(username, password);

        session.setAttribute("username", username);
        session.setAttribute("authorized", "true");
        senRedirect("FrontController?command=UserPage&currentPage=0");
    }
}

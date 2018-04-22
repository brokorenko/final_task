package com.andy.web_task.controller.command;

import com.andy.web_task.service.UserService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationCommand extends FrontCommand {

    private UserService userService = new UserServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        HttpSession session = request.getSession(true);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.checkPassword(username, password)){
            session.setAttribute("authorized", "true");
            session.setAttribute("username", username);
            senRedirect("FrontController?command=UserPage&currentPage=0");
        } else {
            request.setAttribute("cause", "wrong Data");
            forward("view/login_page.jsp");
        }
    }
}

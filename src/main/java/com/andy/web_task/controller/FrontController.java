package com.andy.web_task.controller;

import com.andy.web_task.controller.command.FrontCommand;
import com.andy.web_task.controller.command.UnknownCommand;
import com.andy.web_task.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public final class FrontController extends HttpServlet {

    private static final Logger logger = LogManager.getRootLogger();

    private static final String COMMAND_PATH_PATTERN = "com.andy.web_task.controller.command.%sCommand";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FrontCommand frontCommand = getCommand(req);
        frontCommand.init(getServletContext(), req, resp);

        try {
            frontCommand.process();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ServletException();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FrontCommand frontCommand = getCommand(req);
        frontCommand.init(getServletContext(), req, resp);
        System.out.println("tytaa");
        try {
            System.out.println("wtf");
            frontCommand.process();
            System.out.println(frontCommand.getClass());
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new ServletException();
        }
    }

    private FrontCommand getCommand(ServletRequest request){

        try {
            Class type = Class.forName(String.format(COMMAND_PATH_PATTERN, request.getParameter("command")));
            return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            return new UnknownCommand();
        }
    }
}

package com.andy.web_task.controller.command;

import com.andy.web_task.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

public abstract class FrontCommand {

    //protected чтобы мог пользоваться ими в коммандах
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
   // protected Locale locale;
    protected HttpSession session;

    public final static int ON_PAGE = 10;

    //Не конструктор, иначе в коммандах придется вызывать суперконструктор и передавать туда эти данные
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
        //this.locale = locale;
        this.session = request.getSession(true);
        //session.setAttribute("locale", "RU");
    }

    public abstract void process() throws ServletException, IOException, ServiceException;

    //Чтобы не реализоввывать в коммандах эти методы
    public void forward(String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

    public void senRedirect(String target) throws IOException {
        response.sendRedirect(target);
    }


}

package com.andy.web_task.controller.command.util;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.impl.CompanyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //HttpSession session = servletRequest.getServletContext();
/*        if (session.getAttribute("authorized") != null) {
    }*/
    }
}

package com.andy.web_task.controller.command;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;

public class FillStartPageCommand extends FrontCommand {

    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {

        if (request.getParameter("locale") != null) {
            session.setAttribute("locale", request.getParameter("locale"));
        }

        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int startElement = currentPage * ON_PAGE;

        request.setAttribute("coordinates", companyService.getAllCompanies(startElement, ON_PAGE));
        request.setAttribute("pageCount", companyService.getAllCompaniesPageCount());

        request.setAttribute("commandName", "FillStartPage");
        request.setAttribute("currentPage", currentPage);

        forward("view/start_page.jsp");
    }
}

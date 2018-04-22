package com.andy.web_task.controller.command;

import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.exception.ServiceException;
import com.andy.web_task.service.impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;

public class FiltrateCompanyByTypeCommand extends FrontCommand {

    private CompanyService companyService = new CompanyServiceImpl();

    @Override
    public void process() throws ServletException, IOException, ServiceException {
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int startElement = currentPage * ON_PAGE;
        String type = request.getParameter("type");

        System.out.println(type);

        request.setAttribute("coordinates", companyService.getCompaniesByType(startElement, ON_PAGE, CompanyType.valueOf(type)));
        request.setAttribute("pageCount", companyService.getCompaniesByTypePageCount(CompanyType.valueOf(request.getParameter("type"))));
        request.setAttribute("type", type);
        forward("view/filtrated_company_list.jsp");
    }
}

package com.andy.web_task.service;

import com.andy.web_task.controller.command.CompanyType;
import com.andy.web_task.entity.Company;
import com.andy.web_task.service.exception.ServiceException;

import java.util.List;

public interface CompanyService {

    Company getCompanyInformation(int companyId) throws ServiceException;

    List<Company> getCompaniesByType(int startElement, int count, CompanyType type) throws ServiceException;

    int getCompaniesByTypePageCount(CompanyType type) throws ServiceException;

    List<Company> getUserCompanies(int startElement, int count, String username) throws ServiceException;

    List<Company> getAllCompanies(int startElement, int onPage) throws ServiceException;

    void deleteUserCompany(String username, int companyId) throws ServiceException;

    void editUserCompany(String name, String serviceList, int companyId) throws ServiceException;

    void addCompany(String username, String companyName, String serviceList, String type) throws ServiceException;

    int getAllCompaniesPageCount() throws ServiceException;

    int getUserPageCount(String username) throws ServiceException;
}

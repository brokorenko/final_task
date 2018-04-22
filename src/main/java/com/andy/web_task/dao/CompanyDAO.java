package com.andy.web_task.dao;

import com.andy.web_task.controller.command.CompanyType;
import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.entity.Company;

import java.util.List;

public interface CompanyDAO {

    List<Company> getAllCompanies(int startElement, int count) throws DAOException;
    List<Company> getCompaniesByType(int startElement, int count, CompanyType type) throws DAOException;
    List<Company> getUserCompanies(int startElement, int count, String username) throws DAOException;

    int getAllCompaniesPageCount() throws DAOException;
    int getCompaniesByTypePageCount(CompanyType type) throws DAOException;
    int getUserCompaniesPageCount(String username) throws DAOException;

    Company getCompanyInformation(int companyId) throws DAOException;

    void deleteUserCompany(String username, int companyId) throws DAOException;

    void editUserCompany(String name, String serviceList, int companyId) throws DAOException;

    void addCompany(String username, String companyName, String serviceList, String type) throws DAOException;
}

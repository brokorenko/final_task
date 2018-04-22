package com.andy.web_task.service.impl;

import com.andy.web_task.controller.command.CompanyType;
import com.andy.web_task.dao.CompanyDAO;
import com.andy.web_task.dao.exception.DAOException;
import com.andy.web_task.dao.impl.CompanyDAOImpl;
import com.andy.web_task.entity.Company;
import com.andy.web_task.service.CompanyService;
import com.andy.web_task.service.exception.ServiceException;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private CompanyDAO companyDAO = new CompanyDAOImpl();

    @Override
    public int getAllCompaniesPageCount() throws ServiceException {
        try {
            return companyDAO.getAllCompaniesPageCount();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Company> getAllCompanies(int startElement, int onPage) throws ServiceException {
        try {
            return companyDAO.getAllCompanies(startElement, onPage);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteUserCompany(String username, int companyId) throws ServiceException {
        try {
            companyDAO.deleteUserCompany(username, companyId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void editUserCompany(String name, String serviceList, int companyId) throws ServiceException {
        try {
            companyDAO.editUserCompany(name, serviceList, companyId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void addCompany(String username, String companyName, String serviceList, String type) throws ServiceException {
        try {
            companyDAO.addCompany(username, companyName, serviceList, type);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Company getCompanyInformation(int companyId) throws ServiceException {
        try {
            return companyDAO.getCompanyInformation(companyId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public List<Company> getCompaniesByType(int startElement, int count, CompanyType type) throws ServiceException {
        try {
            return companyDAO.getCompaniesByType(startElement, count, type);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public int getCompaniesByTypePageCount(CompanyType type) throws ServiceException {
        try {
            return companyDAO.getCompaniesByTypePageCount(type);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Company> getUserCompanies(int startElement, int count, String username) throws ServiceException {
        try {
            return companyDAO.getUserCompanies(startElement, count, username);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public int getUserPageCount(String username) throws ServiceException {
        try {
            return companyDAO.getUserCompaniesPageCount(username);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}

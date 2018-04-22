package com.andy.web_task.entity;

import java.io.Serializable;

public class Company implements Serializable {
    private static final long serialVersionUID = 3660040339275009067L;
    private int id;
    private String name;
    private String serviceList;
    private int rate;
    private int typeId;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceList() {
        return serviceList;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() == this.getClass())) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (rate != company.rate) return false;
        if (typeId != company.typeId) return false;
        if (userId != company.userId) return false;
        if (!name.equals(company.name)) return false;
        return serviceList.equals(company.serviceList);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + serviceList.hashCode();
        result = 31 * result + rate;
        result = 31 * result + typeId;
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serviceList='" + serviceList + '\'' +
                ", rate=" + rate +
                ", typeId=" + typeId +
                ", userId=" + userId +
                '}';
    }
}

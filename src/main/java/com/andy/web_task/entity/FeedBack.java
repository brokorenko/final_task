package com.andy.web_task.entity;

import java.io.Serializable;
import java.sql.Date;

public class FeedBack implements Serializable {
    private static final long serialVersionUID = -100830634007267444L;
    private int id;
    private Date date;
    private String content;
    private int companyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(this.getClass() == o.getClass())) return false;

        FeedBack feedBack = (FeedBack) o;

        if (id != feedBack.id) return false;
        if (companyId != feedBack.companyId) return false;
        if (!date.equals(feedBack.date)) return false;
        return content.equals(feedBack.content);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + companyId;
        return result;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}

package com.andy.web_task.entity;

import java.io.Serializable;
import java.sql.Date;

public class FeedBackReply implements Serializable {
    private static final long serialVersionUID = -3714986991230992643L;
    private Date date;
    private String content;
    private int feedbackId;

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

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(this.getClass() == o.getClass())) return false;

        FeedBackReply that = (FeedBackReply) o;

        if (feedbackId != that.feedbackId) return false;
        if (!date.equals(that.date)) return false;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + feedbackId;
        return result;
    }

    @Override
    public String toString() {
        return "FeedBackReply{" +
                "date=" + date +
                ", content='" + content + '\'' +
                ", feedbackId=" + feedbackId +
                '}';
    }
}

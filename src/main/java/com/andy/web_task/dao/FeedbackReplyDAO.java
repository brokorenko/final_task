package com.andy.web_task.dao;

import com.andy.web_task.entity.FeedBackReply;

import java.util.List;

public interface FeedbackReplyDAO {
    List<FeedBackReply> getFeedbackReplyList(int feedbackId);
}

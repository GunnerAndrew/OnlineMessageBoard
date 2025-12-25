package com.example.survey.platform.dao;

import com.example.survey.platform.model.Reply;
import java.util.List;

public interface ReplyDao {
    void addReply(Reply reply);
    List<Reply> getRepliesByMessageId(int messageId);
}

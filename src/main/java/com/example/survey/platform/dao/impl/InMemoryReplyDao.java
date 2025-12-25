// InMemoryReplyDao.java
package com.example.survey.platform.dao.impl;

import com.example.survey.platform.dao.ReplyDao;
import com.example.survey.platform.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryReplyDao implements ReplyDao {

    private final List<Reply> replies = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public void addReply(Reply reply) {
        reply.setId(idCounter.getAndIncrement());
        replies.add(reply);
    }

    @Override
    public List<Reply> getRepliesByMessageId(int messageId) {
        return replies.stream()
                .filter(r -> r.getMessageId() == messageId)
                .collect(Collectors.toList());
    }
}
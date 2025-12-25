// InMemoryMessageDao.java
package com.example.survey.platform.dao.impl;

import com.example.survey.platform.dao.MessageDao;
import com.example.survey.platform.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryMessageDao implements MessageDao {

    private final List<Message> messages = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public void addMessage(Message message) {
        message.setId(idCounter.getAndIncrement());
        messages.add(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages);
    }

    @Override
    public Message getMessageById(int id) {
        return messages.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
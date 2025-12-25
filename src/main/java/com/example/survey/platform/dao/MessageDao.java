package com.example.survey.platform.dao;

import com.example.survey.platform.model.Message;

import java.util.List;

public interface MessageDao {
    void addMessage(Message msg);
    List<Message> getAllMessages();
    Message getMessageById(int id);
}

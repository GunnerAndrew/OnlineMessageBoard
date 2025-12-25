package com.example.survey.platform.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Message {
    private int id;
    private String title;
    private String content;
    private String sender;
    private LocalDateTime datetime;

    // 新增字段：格式化后的时间字符串
    private String datetimeStr;

    // 回复列表
    private List<Reply> replies = new ArrayList<>();

    public Message() {}

    // getter / setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public LocalDateTime getDatetime() { return datetime; }
    public void setDatetime(LocalDateTime datetime) { this.datetime = datetime; }

    public String getDatetimeStr() { return datetimeStr; }
    public void setDatetimeStr(String datetimeStr) { this.datetimeStr = datetimeStr; }

    // 回复列表 getter / setter
    public List<Reply> getReplies() { return replies; }
    public void setReplies(List<Reply> replies) { this.replies = replies; }

    // 方便直接添加回复
    public void addReply(Reply reply) {
        this.replies.add(reply);
    }
}

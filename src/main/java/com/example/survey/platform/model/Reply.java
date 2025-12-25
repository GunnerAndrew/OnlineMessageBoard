package com.example.survey.platform.model;

import java.time.LocalDateTime;

public class Reply {
    private int id;
    private int messageId; // 回复对应的讨论帖ID
    private String content;
    private String sender; // 这里存用户名
    private LocalDateTime datetime;

    // 新增字段：格式化后的时间字符串
    private String datetimeStr;

    public Reply() {
        this.datetime = LocalDateTime.now();
    }

    // 构造方法，自动生成 datetime
    public Reply(int messageId, int id, String content, String sender) {
        this.messageId = messageId;
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.datetime = LocalDateTime.now();
    }

    // 构造方法，可指定 datetime
    public Reply(int messageId, int id, String content, String sender, LocalDateTime datetime) {
        this.messageId = messageId;
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.datetime = datetime;
    }

    // getter / setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMessageId() { return messageId; }
    public void setMessageId(int messageId) { this.messageId = messageId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public LocalDateTime getDatetime() { return datetime; }
    public void setDatetime(LocalDateTime datetime) { this.datetime = datetime; }

    // 新增 datetimeStr 的 getter / setter
    public String getDatetimeStr() { return datetimeStr; }
    public void setDatetimeStr(String datetimeStr) { this.datetimeStr = datetimeStr; }
}

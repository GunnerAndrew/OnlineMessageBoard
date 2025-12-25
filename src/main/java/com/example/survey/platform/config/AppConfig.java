// src/main/java/com/example/survey/platform/config/AppConfig.java
package com.example.survey.platform.config;

import com.example.survey.platform.dao.MessageDao;
import com.example.survey.platform.dao.ReplyDao;
import com.example.survey.platform.dao.UserDao;
import com.example.survey.platform.dao.impl.InMemoryMessageDao;
import com.example.survey.platform.dao.impl.InMemoryReplyDao;
import com.example.survey.platform.dao.impl.InMemoryUserDao;
import com.example.survey.platform.model.User;  // 添加这行
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserDao userDao() {
        InMemoryUserDao dao = new InMemoryUserDao();
        // 初始化测试用户
        dao.addUser(new User(0, "alice", "123"));
        dao.addUser(new User(0, "bob", "123"));
        dao.addUser(new User(0, "tom", "123"));
        return dao;
    }

    @Bean
    public MessageDao messageDao() {
        return new InMemoryMessageDao();
    }

    @Bean
    public ReplyDao replyDao() {
        return new InMemoryReplyDao();
    }
}
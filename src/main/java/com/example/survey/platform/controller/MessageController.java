// MessageController.java
package com.example.survey.platform.controller;

import com.example.survey.platform.dao.MessageDao;
import com.example.survey.platform.dao.ReplyDao;
import com.example.survey.platform.model.Message;
import com.example.survey.platform.model.Reply;
import com.example.survey.platform.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    private final MessageDao messageDao;
    private final ReplyDao replyDao;

    // Spring IOC 依赖注入
    public MessageController(MessageDao messageDao, ReplyDao replyDao) {
        this.messageDao = messageDao;
        this.replyDao = replyDao;
    }

    @GetMapping("/list")
    public String listMessages(Model model) {
        List<Message> messages = messageDao.getAllMessages();

        // 格式化换行符
        messages.forEach(m -> {
            if (m.getContent() != null) {
                m.setContent(m.getContent().replace("\n", "<br/>"));
            }
        });

        model.addAttribute("messages", messages);
        return "index"; // templates/index.html
    }

    @GetMapping("/post")
    public String showPostForm() {
        return "post_message"; // templates/post_message.html
    }

    @PostMapping("/post")
    public String postMessage(@RequestParam String title,
                              @RequestParam String content,
                              HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Message msg = new Message();
        msg.setTitle(title);
        msg.setContent(content);
        msg.setSender(user.getUsername());
        msg.setDatetime(LocalDateTime.now());

        messageDao.addMessage(msg);
        return "redirect:/message/list";
    }

    @GetMapping("/detail")
    public String messageDetail(@RequestParam int id, Model model) {
        Message msg = messageDao.getMessageById(id);
        if (msg != null) {
            List<Reply> replies = replyDao.getRepliesByMessageId(id);

            // 格式化消息内容
            if (msg.getContent() != null) {
                msg.setContent(msg.getContent().replace("\n", "<br/>"));
            }

            // 格式化回复内容
            replies.forEach(r -> {
                if (r.getContent() != null) {
                    r.setContent(r.getContent().replace("\n", "<br/>"));
                }
            });

            model.addAttribute("message", msg);
            model.addAttribute("replies", replies);
            return "message_detail"; // templates/message_detail.html
        } else {
            return "redirect:/message/list";
        }
    }

    @PostMapping("/reply")
    public String replyMessage(@RequestParam int messageId,
                               @RequestParam String content,
                               HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Reply reply = new Reply(messageId, 0, content, user.getUsername(), LocalDateTime.now());
        replyDao.addReply(reply);

        return "redirect:/message/detail?id=" + messageId;
    }
}
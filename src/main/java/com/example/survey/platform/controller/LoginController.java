// LoginController.java
package com.example.survey.platform.controller;

import com.example.survey.platform.dao.UserDao;
import com.example.survey.platform.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    private final UserDao userDao;

    // Spring IOC 依赖注入
    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // 自动查找 templates/login.html
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam String captcha,
                                     HttpSession session) {

        Map<String, Object> result = new HashMap<>();

        // 验证码校验
        String sessionCaptcha = (String) session.getAttribute("captcha");
        if (sessionCaptcha == null || !sessionCaptcha.equalsIgnoreCase(captcha)) {
            result.put("success", false);
            result.put("message", "验证码错误");
            return result;
        }

        // 用户验证
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("message", "用户名或密码错误");
        }

        return result;
    }
}
package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/login/form")
    public String form() {
        return "form";
    }

    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
            model.addAttribute("success", true);
        } else {
            model.addAttribute("message", "Đăng nhập thất bại! Username phải là 'poly' và password phải là '123'");
            model.addAttribute("success", false);
        }

        return "form";
    }
}

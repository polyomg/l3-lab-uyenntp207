package com.poly.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/demo/index"; // chuyển trang chủ về index chính
    }

    @GetMapping("/demo/index")
    public String index() {
        return "demo/index";
    }
}

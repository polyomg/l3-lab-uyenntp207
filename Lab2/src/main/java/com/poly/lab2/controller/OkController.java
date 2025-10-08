package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OkController {
    //    Ok1 - post /ok
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("result", "m1");
        return "ok";
    }

    //    Ok2 - get /ok
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("result", "m2");
        return "ok";
    }

    //    OK3 - post /ok?x
    @PostMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("result", "m3");
        return "ok";
    }
}

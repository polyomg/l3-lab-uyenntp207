package com.poly.lab5.controller;

import com.poly.lab5.util.DB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    @RequestMapping("/item/index")
    public String list(Model model) { // một mapping duy nhất
        model.addAttribute("items", DB.items.values());
        return "item/list";
    }
}

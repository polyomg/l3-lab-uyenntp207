package com.poly.lab6.controller;

import com.poly.lab6.dao.CategoryDao;
import com.poly.lab6.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDao dao;

    @GetMapping("/CategoryHome")
    public String CategoryHome(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);

        List<Category> items = dao.findAll();
        model.addAttribute("items", items);

        return "category/CategoryHome";
    }

    @PostMapping("/create")
    public String create(Category item) {
        dao.save(item);
        return "redirect:/category/CategoryHome";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Optional<Category> item = dao.findById(id);
        item.ifPresent(c -> model.addAttribute("item", c));
        model.addAttribute("items", dao.findAll());
        return "category/CategoryHome";
    }

    @PostMapping("/update")
    public String update(Category item) {
        dao.save(item);
        return "redirect:/category/CategoryHome";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dao.deleteById(id);
        return "redirect:/category/CategoryHome";
    }
}


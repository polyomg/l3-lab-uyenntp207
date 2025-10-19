package com.poly.lab6.controller;

import com.poly.lab6.dao.ProductDao;
import com.poly.lab6.dao.CategoryDao;
import com.poly.lab6.dao.OrderDetailDao;
import com.poly.lab6.entity.Product;
import com.poly.lab6.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDao pdao;

    @Autowired
    CategoryDao cdao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @GetMapping("/ProductHome")
    public String ProductHome(Model model) {
        Product item = new Product();
        model.addAttribute("item", item);

        List<Product> items = pdao.findAll();
        model.addAttribute("items", items);

        List<Category> categories = cdao.findAll();
        model.addAttribute("categories", categories);

        return "product/ProductHome";
    }

    @PostMapping("/create")
    public String create(Product item) {
        pdao.save(item);
        return "redirect:/product/ProductHome";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Optional<Product> item = pdao.findById(id);
        item.ifPresent(p -> model.addAttribute("item", p));

        model.addAttribute("items", pdao.findAll());
        model.addAttribute("categories", cdao.findAll());
        return "product/ProductHome";
    }

    @PostMapping("/update")
    public String update(Product item) {
        pdao.save(item);
        return "redirect:/product/ProductHome";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        orderDetailDao.deleteByProductId(id); // Xóa OrderDetails trước
        pdao.deleteById(id); // Sau đó xóa Product
        return "redirect:/product/ProductHome";
    }
    // ====================== BÀI 3 – Giảm dần theo cột, khởi đầu là GIÁ  ======================
    @GetMapping("/sort")
    public String sort(Model model,
                       @RequestParam(value = "field", defaultValue = "price") String field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field);
        List<Product> items = pdao.findAll(sort);
        model.addAttribute("items", items);
        model.addAttribute("field", field);
        return "product/sort";
    }

    // ====================== BÀI 4 – PHÂN TRANG ======================
    @GetMapping("/page")
    public String page(Model model,
                       @RequestParam("p") Optional<Integer> p) {

        int pageNumber = p.orElse(0); // nếu không có tham số, mặc định là trang 0
        Pageable pageable = PageRequest.of(pageNumber, 5); // mỗi trang 5 sản phẩm

        Page<Product> page = pdao.findAll(pageable);
        model.addAttribute("page", page);

        return "product/page";
    }

    // ====================== BÀI 5 – PHÂN TRANG + SẮP XẾP ======================
    @GetMapping("/page-sort")
    public String pageAndSort(Model model,
                              @RequestParam("p") Optional<Integer> p,
                              @RequestParam(value = "field", defaultValue = "price") String field,
                              @RequestParam(value = "dir", defaultValue = "DESC") String dir) {

        int pageNumber = p.orElse(0); // trang hiện tại (mặc định trang đầu tiên)
        Sort.Direction direction = dir.equalsIgnoreCase("ASC")
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(pageNumber, 5, Sort.by(direction, field));
        Page<Product> page = pdao.findAll(pageable);

        model.addAttribute("page", page);
        model.addAttribute("field", field);
        model.addAttribute("dir", dir);

        return "product/page-sort";
    }
}

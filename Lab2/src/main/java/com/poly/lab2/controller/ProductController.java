package poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    // Danh sách sản phẩm lưu trữ động
    private List<Product> items = new ArrayList<>(Arrays.asList(
            new Product("iPhone 15", 1200.0),
            new Product("Samsung Galaxy S24", 1100.0),
            new Product("MacBook Pro M3", 2500.0),
            new Product("Dell XPS 15", 2000.0),
            new Product("Asus ROG Strix", 1800.0),
            new Product("HP Spectre x360", 1700.0),
            new Product("iPad Pro 12.9", 1400.0),
            new Product("Apple Watch Ultra 2", 900.0),
            new Product("AirPods Pro 2", 250.0),
            new Product("Sony WH-1000XM5", 400.0),
            new Product("Canon EOS R7", 1500.0),
            new Product("Nikon Z6 II", 1600.0),
            new Product("GoPro Hero 12", 500.0),
            new Product("PlayStation 5", 600.0),
            new Product("Xbox Series X", 550.0),
            new Product("Nintendo Switch OLED", 350.0),
            new Product("LG OLED C3 TV", 2200.0),
            new Product("Samsung Neo QLED TV", 2400.0),
            new Product("Bose Soundbar 900", 800.0),
            new Product("Dyson V15 Vacuum", 700.0)
    ));

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p", p); // ?1
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("p") Product p, Model model) { // ?2
        items.add(p); // Thêm sản phẩm mới vào danh sách
        model.addAttribute("p", p);
        return "product/form";
    }

    @ModelAttribute("items") // ?3
    public List<Product> getItems() {
        return items;
    }
}

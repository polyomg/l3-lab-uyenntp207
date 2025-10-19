package com.poly.lab5.controller;

import com.poly.lab5.service.CookieService;
import com.poly.lab5.service.ParamService;
import com.poly.lab5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccountController {
    @Autowired CookieService cookieService;
    @Autowired ParamService paramService;
    @Autowired SessionService sessionService;

    // LOGIN
    @GetMapping("/account/login")
    public String loginForm(Model model, @RequestParam(name="error", required=false) String error) {
        if(error != null) model.addAttribute("error", error);
        // tự động điền username từ cookie nếu có
        String remembered = cookieService.getValue("user");
        if(!remembered.isBlank()) {
            model.addAttribute("rememberedUser", remembered);
        }
        return "account/login";
    }

    @PostMapping("/account/login")
    public String doLogin(Model model) {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);
        if("poly".equals(un) && "123".equals(pw)) {
            sessionService.set("username", un);
            if(rm) {
                // 10 ngày = 10 * 24 giờ
                cookieService.add("user", un, 10 * 24);
            } else {
                cookieService.remove("user");
            }
            return "redirect:/";
        }
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
        model.addAttribute("rememberedUser", cookieService.getValue("user"));
        return "account/login";
    }

    // REGISTER
    @GetMapping("/account/register")
    public String registerForm() {
        return "account/register";
    }

    @PostMapping("/account/register")
    public String register(@RequestParam("photo") MultipartFile file) {
        paramService.save(file, "/uploads");
        return "redirect:/account/login";
    }

    // LOGOUT
    @GetMapping("/account/logout")
    public String logout() {
        sessionService.remove("username");
        return "redirect:/";
    }
}

package com.poly.controller;

import com.poly.bean.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.validation.Errors;
import jakarta.validation.Valid;

@Controller
public class StaffController {

    @RequestMapping("/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "demo/staff-create";
    }

    @RequestMapping("/staff/create/save")
    public String createSave(Model model,
            @RequestPart("photo_file") MultipartFile photoFile,
            @Valid @ModelAttribute("staff") Staff staff,
            Errors errors) {

        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
            return "demo/staff-create";
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
            return "demo/staff-validate";
        }
    }
}

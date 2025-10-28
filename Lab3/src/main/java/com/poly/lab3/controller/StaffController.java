package com.poly.lab3.controller;

import com.poly.lab3.bean.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StaffController {
    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("cuunon@gmail.com")
                .fullname("nguyễn văn cứu")
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "demo/staff-detail";
    }

    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff> list = sample();
        model.addAttribute("list", list);
        return "demo/staff-list";
    }

    @RequestMapping("/staff/list-status")
    public String listStatus(Model model) {
        List<Staff> list = sample();
        model.addAttribute("list", list);
        return "demo/list-status";
    }

    @RequestMapping("/staff/list-controls")
    public String listControls(Model model) {
        List<Staff> list = sample();
        model.addAttribute("list", list);
        return "demo/list-controls";
    }

    // ===== BÀI 3: SUMMARY THỐNG KÊ =====
    @RequestMapping("/staff/summary")
    public String summary(Model model) {
        List<Staff> list = sample();
        model.addAttribute("list", list);
        int total = list.size();
        double avgSalary = list.stream().mapToDouble(s -> s.getSalary()).average().orElse(0);
        double minSalary = list.stream().mapToDouble(Staff::getSalary).min().orElse(0);
        double maxSalary = list.stream().mapToDouble(Staff::getSalary).max().orElse(0);
        long maleCount = list.stream().filter(s -> Boolean.TRUE.equals(s.getGender())).count();
        long femaleCount = total - maleCount;
        Map<Integer, Long> byLevel = list.stream().collect(Collectors.groupingBy(Staff::getLevel, Collectors.counting()));
        model.addAttribute("total", total);
        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("minSalary", minSalary);
        model.addAttribute("maxSalary", maxSalary);
        model.addAttribute("maleCount", maleCount);
        model.addAttribute("femaleCount", femaleCount);
        model.addAttribute("byLevel", byLevel);
        return "demo/staff-summary";
    }

    // Helper dùng chung danh sách mẫu
    private List<Staff> sample() {
        return List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
        );
    }
}

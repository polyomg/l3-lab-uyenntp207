# LAB4: THYMELEAF 2

## 🎯 MỤC TIÊU
- ✅ Thực hiện 2 way data binding
- ✅ Thực hiện form validation  
- ✅ Tổ chức layout
- ✅ Tổ chức website đa ngôn ngữ

## 🚀 CÁCH CHẠY

### Tự động (Khuyến nghị):
```bash
# Windows
lab4.cmd

# Linux/Mac  
./lab4.sh
```

### Thủ công:
```bash
# Clean và compile
./mvnw.cmd clean compile

# Chạy ứng dụng
./mvnw.cmd spring-boot:run
```

## 📝 CÁC BÀI

### Bài 1: Databinding (2 điểm)
- **URL**: http://localhost:8080/staff/create/form
- **Tính năng**: Ràng buộc dữ liệu 2 chiều giữa bean và form

### Bài 2: Form Validation (2 điểm)  
- **URL**: http://localhost:8080/staff/create/form
- **Tính năng**: Kiểm tra validation với backend

### Bài 4: Layout (2 điểm)
- **URL**: http://localhost:8080/home/index, /home/about
- **Tính năng**: Website với layout chung (header, menu, content, footer)

### Bài 5: Đa ngôn ngữ (2 điểm)
- **URL**: http://localhost:8080/home/index?lang=vi hoặc ?lang=en
- **Tính năng**: Chuyển đổi giữa Tiếng Việt và English

## 🌐 TRUY CẬP
- **Trang chủ**: http://localhost:8080/
- **Port**: 8080

## 📁 CẤU TRÚC PROJECT
```
Lab4/
├── src/main/java/com/poly/
│   ├── Lab4Application.java
│   ├── bean/Staff.java
│   ├── controller/
│   └── config/MessageConfig.java
├── src/main/resources/
│   ├── templates/
│   ├── i18n/
│   └── static/
├── lab4.cmd (Windows)
├── lab4.sh (Linux/Mac)
└── pom.xml
```

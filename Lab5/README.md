# Lab5 - Spring Beans Project

## Cấu trúc dự án sau cleanup

### Controllers hoạt động:
- `AccountController.java` - Xử lý đăng nhập/đăng ký/đăng xuất
- `ItemController.java` - Hiển thị danh sách sản phẩm
- `ShoppingCartController.java` - Quản lý giỏ hàng
- `GlobalModelAttributes.java` - Cung cấp cartCount cho tất cả view

### Services:
- `ParamService.java` - Xử lý parameters từ request
- `CookieService.java` - Quản lý cookies
- `SessionService.java` - Quản lý session
- `ShoppingCartService.java` (interface) + `ShoppingCartServiceImpl.java` - Logic giỏ hàng

### Models & Utils:
- `Item.java` - Model sản phẩm
- `DB.java` - Dữ liệu mẫu sản phẩm

### Templates hoạt động:
- `/index.html` - Trang chủ portal (thay thế home/index.html)
- `/account/login.html` - Form đăng nhập (có xử lý lỗi, remember me)
- `/account/register.html` - Form đăng ký (có upload file)
- `/item/list.html` - Danh sách sản phẩm
- `/cart/view.html` - Giỏ hàng

### Static Resources:
- `/css/style.css` - CSS đẹp, responsive

### URLs chính:
- `/` - Trang chủ
- `/account/login` - Đăng nhập (poly/123)
- `/account/register` - Đăng ký
- `/account/logout` - Đăng xuất
- `/item/index` - Sản phẩm
- `/cart/view` - Giỏ hàng
- `/cart/add/{id}`, `/cart/remove/{id}`, `/cart/update/{id}`, `/cart/clear` - Thao tác giỏ hàng

### Tính năng đã implement:
✅ ParamService (getString, getInt, getDouble, getBoolean, getDate, save)
✅ CookieService (get, getValue, add, remove)
✅ SessionService (get, set, remove)
✅ Shopping Cart với session scope
✅ Login/Register/Logout
✅ Remember me (cookie 10 ngày)
✅ File upload
✅ Responsive UI
✅ Error handling

### Files đã xóa/cleanup:
- `HomeController.java` - Không cần vì dùng static index.html
- `home/index.html` - Đã merge vào index.html gốc
- `item/index.html`, `cart/index.html` - Thay bằng list.html và view.html

Dự án hoàn chỉnh, gọn gàng, ready để chạy và demo!

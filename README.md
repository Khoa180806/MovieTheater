# 🎬 Hệ Thống Quản Lý Rạp Chiếu Phim (OOP MovieTheater)

## 📝 Mô Tả Dự Án

Đây là một hệ thống quản lý rạp chiếu phim được phát triển bằng Java, áp dụng các nguyên lý lập trình hướng đối tượng (OOP). Hệ thống cho phép quản lý phim, suất chiếu, bán vé và theo dõi thông tin khách hàng.

## ✨ Tính Năng Chính

### 👨‍💼 Chức năng dành cho Quản trị viên (Admin):
- ➕ Thêm phim mới
- 📅 Thêm suất chiếu
- 🔍 Tìm kiếm phim theo ID
- 🔍 Tìm kiếm suất chiếu theo ID
- ✏️ Cập nhật thông tin phim
- ✏️ Cập nhật thông tin suất chiếu
- 🗑️ Xóa phim
- 🗑️ Xóa suất chiếu
- 📋 Xem danh sách tất cả phim
- 📋 Xem danh sách tất cả suất chiếu
- 🎫 Xem danh sách tất cả vé đã bán

### 👤 Chức năng dành cho Khách hàng (Customer):
- 🎫 Mua vé xem phim
- 📱 Xem danh sách vé đã mua
- 💺 Chọn ghế ngồi (50 ghế/phòng chiếu)

## 🏗️ Cấu Trúc Dự Án

```
OOP_MovieTheater/
├── entity/                    # Các lớp thực thể
│   ├── User.java             # Lớp cha trừu tượng cho người dùng
│   ├── Admin.java            # Lớp quản trị viên
│   ├── Customer.java         # Lớp khách hàng
│   ├── Movie.java            # Lớp phim
│   ├── ShowTime.java         # Lớp suất chiếu
│   └── Ticket.java           # Lớp vé
├── service/                  # Các lớp dịch vụ
│   ├── AdminService.java     # Interface dịch vụ admin
│   ├── AdminServiceImpl.java # Triển khai dịch vụ admin
│   ├── CustomerService.java  # Interface dịch vụ customer
│   └── CustomerServiceImpl.java # Triển khai dịch vụ customer
├── Main.java                 # File chính để chạy ứng dụng
└── README.md                 # Tài liệu hướng dẫn
```

## 🎯 Các Lớp và Chức Năng

### 📦 Package Entity

- **User**: Lớp trừu tượng chứa thông tin cơ bản (username, password, role)
- **Admin**: Kế thừa từ User, có menu quản trị viên
- **Customer**: Kế thừa từ User, có menu khách hàng
- **Movie**: Quản lý thông tin phim (ID, tên, thể loại, thời lượng)
- **ShowTime**: Quản lý suất chiếu (ID, ngày chiếu, phòng, ID phim)
- **Ticket**: Quản lý vé (ID, ngày chiếu, phòng, ghế, tên khách hàng)

### 🛠️ Package Service

- **AdminService/AdminServiceImpl**: Xử lý logic nghiệp vụ cho quản trị viên
- **CustomerService/CustomerServiceImpl**: Xử lý logic nghiệp vụ cho khách hàng

## 🚀 Cách Chạy Dự Án

### Yêu Cầu Hệ Thống:
- Java Development Kit (JDK) 8 hoặc cao hơn
- IDE Java (Eclipse, IntelliJ IDEA, VS Code) hoặc command line

### Các Bước Chạy:

1. **Clone hoặc download dự án về máy**
```bash
git clone <repository-url>
cd OOP_MovieTheater
```

2. **Biên dịch dự án**
```bash
javac -d . *.java entity/*.java service/*.java
```

3. **Chạy ứng dụng**
```bash
java Main
```

## 📖 Hướng Dẫn Sử Dụng

### 🔐 Đăng Nhập
- Khi khởi động, hệ thống sẽ yêu cầu đăng nhập
- Chọn loại tài khoản: Admin hoặc Customer
- Nhập username và password

### 👨‍💼 Sử Dụng Với Tài Khoản Admin
1. Chọn chức năng từ menu (1-12)
2. Thêm phim: Nhập ID, tên, thể loại, thời lượng
3. Thêm suất chiếu: Chọn phim, nhập ngày và phòng chiếu
4. Quản lý: Tìm kiếm, cập nhật, xóa theo ID
5. Xem báo cáo: Danh sách phim, suất chiếu, vé đã bán

### 👤 Sử Dụng Với Tài Khoản Customer
1. Mua vé: Chọn phim → Chọn suất chiếu → Chọn ghế ngồi
2. Xem vé đã mua: Hiển thị danh sách vé của khách hàng
3. Đăng xuất

## 🎯 Tính Năng Nổi Bật

- **🎭 Quản lý đa dạng**: Phim, suất chiếu, vé, người dùng
- **💺 Quản lý ghế ngồi**: Hiển thị ghế trống/đã đặt, tối đa 50 ghế/phòng
- **🔒 Phân quyền người dùng**: Admin và Customer có quyền hạn khác nhau
- **🎲 Tự động tạo ID**: Hệ thống tự động tạo ID cho suất chiếu và vé
- **🎨 Giao diện console**: Menu rõ ràng, dễ sử dụng
- **🔄 Vòng lặp ứng dụng**: Có thể sử dụng liên tục cho đến khi chọn thoát

## 🛠️ Phát Triển Thêm

Các tính năng có thể bổ sung:
- 💾 Lưu trữ dữ liệu vào file/database
- 💳 Tính toán giá vé và thanh toán
- 📊 Báo cáo doanh thu theo thời gian
- 🎬 Quản lý thể loại phim chi tiết hơn
- 📧 Gửi email xác nhận vé
- 🌐 Phát triển giao diện web

## 👨‍💻 Tác Giả

Dự án được phát triển như một bài tập lập trình hướng đối tượng, minh họa các khái niệm:
- Kế thừa (Inheritance)
- Đa hình (Polymorphism)
- Đóng gói (Encapsulation)
- Trừu tượng (Abstraction)

## 📞 Liên Hệ

Nếu có thắc mắc hoặc góp ý, vui lòng tạo issue trên repository này.

---
*🎬 Chúc bạn sử dụng hệ thống vui vẻ! 🍿*
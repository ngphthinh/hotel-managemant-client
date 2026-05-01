# 🏨 Hotel Management System - Đào Tiên Hotel

> Ứng dụng **Frontend/Client** desktop được phát triển bằng **Java Swing** để kết nối tới hệ thống quản lý khách sạn.

---

## 🔗 Backend / Server repository

Mã nguồn server của dự án nằm tại:

https://github.com/ngphthinh/daotien-hotel-management.git

---

## 📋 Giới thiệu

Đây là phần **client** của hệ thống, chịu trách nhiệm hiển thị giao diện, xử lý tương tác người dùng và giao tiếp với server qua socket.

Ứng dụng hỗ trợ các luồng nghiệp vụ chính như:

- ✅ Đăng nhập / đăng xuất
- ✅ Quản lý phòng, khách hàng, nhân viên
- ✅ Đặt phòng và thanh toán
- ✅ Quản lý dịch vụ, phụ thu, hóa đơn
- ✅ Dashboard thống kê và biểu đồ
- ✅ In hóa đơn PDF / cập nhật dữ liệu từ server

---

## 🛠️ Công nghệ sử dụng

| Công nghệ | Mục đích |
|----------|----------|
| **Java 17** | Ngôn ngữ lập trình chính |
| **Java Swing** | Giao diện desktop |
| **Maven** | Quản lý dependencies và build |
| **Socket / Object Stream** | Giao tiếp với server |
| **JasperReports** | Xuất / in hóa đơn PDF |
| **FlatLaf** | Giao diện hiện đại |
| **MigLayout** | Bố cục UI |

---

## ⚙️ Cấu hình cần thiết

File cấu hình chính của client:

```properties
src/main/resources/application.properties
```

Ví dụ hiện tại:

```properties
server.port=3637
server.host=LAPTOP-Q1PTRMJM
```

> Nếu server chạy trên máy khác, hãy đổi `server.host` cho phù hợp.

---

## 🚀 Cách chạy ứng dụng

### 1) Build project

```bash
mvn clean package
```

### 2) Chạy ứng dụng

- Mở project bằng IntelliJ IDEA / Eclipse / NetBeans
- Chạy class chính: `iuh.fit.se.group1.Main`

Hoặc chạy từ JAR sau khi build:

```bash
java -jar target/hotel-mamanger-client-1.0-SNAPSHOT.jar
```

---

## 📌 Lưu ý

- Backend/server cần được khởi động trước khi mở client.
- Nếu không kết nối được, kiểm tra lại `server.host` và `server.port`.
- Repository này chỉ chứa phần **frontend/client**.

---

## 👥 Nhóm phát triển

- Nhóm 1 - Khoa Công nghệ Thông tin, IUH
  - Thành viên nhóm:
    - Nguyễn Phước Thịnh (23642651) - Team Leader
    - Trầm Hồng Viên Thiệu (23658881) - Developer & Documentation
    - Nguyễn Trần Quốc Việt (23660721) - Developer
    - Hồ Thị Kim Xuyến (23648471) - Tester & Documentation & Developer

---

## 📄 License

Dự án này được sử dụng cho mục đích học tập và phát triển nội bộ.

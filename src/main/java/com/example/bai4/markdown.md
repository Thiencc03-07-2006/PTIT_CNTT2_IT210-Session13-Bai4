# HQL vs Native Query

### 1. Native SQL
* **Viết trực tiếp** theo bảng và cột trong DB:
  `SELECT * FROM medicines WHERE expiry_date < CURDATE();`

**Nhược điểm:**
* **Phụ thuộc chặt vào schema database**
* **Nếu đổi tên:**
    * bảng `medicines` → `drug`
    * cột `expiry_date` → `exp_date`
    * → toàn bộ query Java bị lỗi
* **Khó maintain**, dễ vỡ hệ thống khi refactor DB

---

### 2. HQL (Hibernate Query Language)
* **Làm việc với Entity (class Java)**, không phải bảng:
  `FROM Medicine m WHERE m.expiryDate < :currentDate`

**Ưu điểm cốt lõi:**
* **Không phụ thuộc trực tiếp DB schema**
* **Mapping thông qua:**
    * `@Entity`
    * `@Column`
* **Khi DB thay đổi:** chỉ cần sửa annotation → **KHÔNG** phải sửa query

---

### Kết luận
HQL giúp code an toàn hơn khi DB thay đổi vì:
* Query dựa trên **object model (OOP)** thay vì schema.
* Hibernate đóng vai trò **abstraction layer**.
* **Giảm coupling giữa:** Application code ↔ Database.

Đây chính là nguyên lý **ORM (Object Relational Mapping)**.
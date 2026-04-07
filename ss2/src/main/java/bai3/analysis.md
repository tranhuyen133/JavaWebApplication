# Phân tích Scope và Implicit Objects

## 1. Tại sao thông báo lỗi đăng nhập phải lưu ở Request Scope?

Thông báo lỗi đăng nhập chỉ cần tồn tại trong đúng một lần submit sai rồi render lại trang login.  
Đây là dữ liệu ngắn hạn, không cần giữ qua các request tiếp theo.

Nếu lưu nhầm vào Session Scope thì lỗi sẽ bám theo cả phiên:
- Người dùng đăng nhập sai 1 lần
- Sau đó tải lại trang hoặc đi sang trang khác
- Thông báo lỗi cũ vẫn có thể còn xuất hiện
- Gây nhầm lẫn vì lỗi không còn đúng với trạng thái hiện tại

Vì vậy, lỗi đăng nhập nên dùng Request Scope.

---

## 2. Tại sao totalViewCount phải lưu ở Application Scope?

`totalViewCount` là biến đếm dùng chung cho toàn bộ hệ thống.
Mọi nhân viên đều phải nhìn thấy cùng một con số tổng.

Nếu lưu vào Session Scope thì:
- Nhân viên A có counter riêng
- Nhân viên B có counter riêng
- Mỗi người sẽ thấy một số khác nhau
- Không còn là “tổng lượt xem toàn hệ thống”

Do đó biến này phải lưu trong Application Scope.

---

## 3. Race Condition là gì?

Race Condition là tình huống nhiều luồng cùng truy cập và cập nhật một dữ liệu dùng chung cùng lúc,
làm cho kết quả cuối cùng bị sai do thứ tự thực thi không xác định.

Ví dụ đoạn code sau:

```java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);
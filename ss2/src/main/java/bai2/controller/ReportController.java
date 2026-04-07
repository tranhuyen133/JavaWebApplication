package bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class ReportController {

    @GetMapping("/report")
    public String report(Model model) {
        List<Map<String, Object>> students = new ArrayList<>();

        Map<String, Object> s1 = new HashMap<>();
        s1.put("id", "SV01");
        s1.put("name", "Nguyễn Văn A");
        s1.put("subject", "Java");
        s1.put("score", 8);
        s1.put("comment", "Học tốt");

        Map<String, Object> s2 = new HashMap<>();
        s2.put("id", "SV02");
        s2.put("name", "Trần Văn B");
        s2.put("subject", "SQL");
        s2.put("score", 4);
        s2.put("comment", "<script>alert('XSS')</script>");

        students.add(s1);
        students.add(s2);

        model.addAttribute("reportTitle", "Báo cáo điểm sinh viên");
        model.addAttribute("students", students);

        return "report";
    }
}
//# Phần 1 — Phân tích logic
//
//| # | Vị trí (dòng/thành phần) | Loại vấn đề | Mô tả chi tiết hậu quả |
//        |---|---|---|---|
//        | 1 | `<%! private int requestCounter = 0; %>` | Race Condition / Shared State | Đây là **Declaration** trong JSP, tức là biến được khai báo ở mức field của servlet sinh ra từ JSP, không phải biến cục bộ cho từng request. Khi nhiều người dùng truy cập đồng thời, nhiều luồng cùng đọc/ghi vào `requestCounter` có thể làm sai giá trị đếm, gây race condition. Ngoài ra dữ liệu còn bị dùng chung giữa các request, không phù hợp với nguyên tắc thiết kế view. |
//        | 2 | `<!-- comment nội bộ -->` | Sai loại comment | Nếu dùng **HTML comment** để ghi chú nội bộ thì comment này vẫn được gửi xuống trình duyệt. Người dùng có thể bấm View Source để thấy nội dung comment, gây lộ ghi chú kỹ thuật hoặc thông tin nội bộ. Với ghi chú trong JSP phải dùng **JSP Comment**: `<%-- --%>`. |
//        | 3 | `<%= student.getName(); %>` hoặc expression có dấu `;` | Sai cú pháp Expression | Trong JSP Expression, phần bên trong phải là **biểu thức trả về giá trị**, không viết dấu chấm phẩy `;` như câu lệnh Java. Viết `;` có thể gây lỗi biên dịch JSP hoặc ít nhất là sai chuẩn cú pháp, làm code khó đọc và dễ nhầm với scriptlet. |
//        | 4 | Vòng lặp `for (...) { ... }` hoặc `if (...) { ... }` viết bằng `<% %>` trong JSP | Logic trong View / Vi phạm Thin View | JSP chỉ nên đóng vai trò hiển thị dữ liệu. Khi nhét Java code như vòng lặp, điều kiện, tính toán trực tiếp vào view thì file JSP trở nên rối, khó đọc, khó bảo trì và khó test. Điều này vi phạm nguyên tắc **View ngốc nghếch (Thin View)**. Đúng chuẩn là dùng **JSTL** như `<c:forEach>`, `<c:choose>`, `<c:when>`. |
//        | 5 | In dữ liệu người dùng bằng `<%= request.getParameter("name") %>` hoặc `${param.name}` trực tiếp | XSS | Nếu dữ liệu đầu vào chứa mã độc như `<script>alert('hack')</script>` mà được in thẳng ra HTML, trình duyệt có thể thực thi đoạn script đó. Đây là lỗ hổng **Cross-Site Scripting (XSS)**. Cách an toàn là dùng `<c:out>` để escape dữ liệu trước khi hiển thị. |
//        | 6 | Dùng `<%! %>` để khai báo method/phép tính hỗ trợ hiển thị | Code smell / Trộn trách nhiệm | Declaration trong JSP làm view chứa luôn logic Java, khiến JSP vừa làm nhiệm vụ hiển thị vừa làm nhiệm vụ xử lý. Điều này làm code khó tái sử dụng, khó bảo trì, và sai tinh thần MVC. Các phép tính/xử lý nên nằm ở Controller hoặc Service, không nên để trong JSP. |
//        | 7 | Xen kẽ nhiều đoạn `<% ... %>` giữa HTML table | Khó bảo trì / Dễ lỗi cấu trúc | Khi HTML và Java đan xen quá nhiều, rất dễ gây lỗi thiếu đóng mở thẻ, lệch `{}` hoặc sai `%>`. Những lỗi này khiến JSP compile khó debug, đặc biệt khi bảng dữ liệu dài hoặc có nhiều điều kiện hiển thị. |
//        | 8 | Hiển thị dữ liệu bằng `<%= ... %>` thay vì EL `${...}` | Không tối ưu / Cú pháp cũ | Dùng Expression JSP kiểu cũ làm code dài, khó đọc và phụ thuộc nhiều vào Java trong view. Trong Spring MVC hiện đại, nên dùng **EL `${}`** kết hợp JSTL để code ngắn gọn, rõ nghĩa và đúng chuẩn hơn. |
//
//        ---
//
//        ## Kết luận
//
//Trang JSP hiện tại có nhiều vấn đề cả về cú pháp lẫn thiết kế:
//
//        - Dùng sai loại comment giữa HTML comment và JSP comment
//- Viết sai expression khi thêm dấu `;`
//        - Dùng declaration `<%! %>` tạo biến dùng chung gây race condition
//- Đặt quá nhiều logic Java trực tiếp trong view
//- In dữ liệu người dùng không escape gây nguy cơ XSS
//
//        Vì vậy, trang này cần được refactor lại theo hướng:
//
//        - Bỏ toàn bộ `scriptlet` và `declaration`
//        - Dùng **EL `${}`**
//        - Dùng **JSTL** như `<c:forEach>`, `<c:choose>`
//        - Dùng **`<c:out>`** để chống XSS
//- Dùng **`<%-- --%>`** cho ghi chú nội bộ
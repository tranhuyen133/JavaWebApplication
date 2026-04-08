package re.mvc.bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class OrderController {

    // ========================= CÁCH A - ĐƯỢC CHỌN =========================
    // URL: /bai3/orders/5
    // Số 5 nằm trong đường dẫn URL (URI Path)
    // Dùng @PathVariable để lấy giá trị trên đường dẫn
    // Đây là cách phù hợp hơn khi lấy ID của một đối tượng cụ thể
    @GetMapping(value = "/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") Long id) {
        return "Chi tiet don hang so " + id;
    }

    // ========================= CÁCH B - CHỈ ĐỂ SO SÁNH =========================
    // URL: /bai3/orders?id=5
    // Số 5 nằm trong chuỗi truy vấn (Query String)
    // Cách này thường phù hợp cho tìm kiếm, lọc dữ liệu hơn là định danh tài nguyên cụ thể
    // Không dùng trong bài này vì em chọn Cách A

//    @GetMapping(value = "/orders")
//    @ResponseBody
//    public String getOrderById(@RequestParam("id") Long id) {
//        return "Chi tiết đơn hàng số " + id;
//    }

}
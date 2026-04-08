package re.mvc.bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bai2")
public class MenuController {

    // ========================= BẢN SAI =========================
    // Lỗi:
    // @RequestParam("category") mặc định là bắt buộc.
    // Khi truy cập /bai2/menu mà không truyền ?category=...
    // Spring sẽ không nhận được tham số category và ném ra lỗi 400 Bad Request.
    //
    // Ví dụ URL gây lỗi:
    // http://localhost:8080/bai2/menu
    //
    // Code sai:

//    @GetMapping(value = "/menu")
//    @ResponseBody
//    public String getMenu(@RequestParam("category") String category) {
//        return "Thực đơn loại: " + category;
//    }


    // ========================= BẢN ĐÚNG =========================
    // Cách sửa:
    // required = false  -> tham số không còn bắt buộc
    // defaultValue = "chay" -> nếu không truyền category thì tự lấy "chay"
    //
    // Kết quả:
    // /bai2/menu                -> Thực đơn loại: chay
    // /bai2/menu?category=lau   -> Thực đơn loại: lau
    @GetMapping(value = "/menu")
    @ResponseBody
    public String getMenu(
            @RequestParam(value = "category", required = false, defaultValue = "chay") String category
    ) {
        return "Thuc don loai : " + category;
    }
}

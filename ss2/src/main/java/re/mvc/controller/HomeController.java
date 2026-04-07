package re.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // đây là lớp tiếp nhận request
public class HomeController {

    // request gửi lên đường dẫn là gì, phương thức là gì
    @GetMapping("/demo")
    public String handleDemo(Model model) {
        // trả về giao diện jsp
        // gửi biến sang jsp
        model.addAttribute("age", 20); // thêm dữ liệu vào model để truyền sang view
        model.addAttribute("name", "John Doe");
        model.addAttribute("List",new int []{1,3,5,7,8});
        // trả về giao diện
        return "demo"; // trả về tên view (demo.jsp)
    }

    @GetMapping("/submit")
    public String handleSubmit(@RequestParam int a) {
        System.out.println(a);
        return "demo";
    }
}
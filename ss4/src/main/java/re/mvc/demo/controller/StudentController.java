package re.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

// định nghĩa đừng dẫn chung
@RequestMapping("/student") // http://localhost:8080/student/home
public class StudentController { // tiếp nhận yêu cầu
    //@RequestMapping : ánh xạ request theo đường dẫn và phương thức
    //GetMapping và @PostMapping : là casc biến hể của requestMapping chỉ định phương thức get hoặc post
    @RequestMapping("/home")  // mặc định là get

    public String home(){
        // tự động chuyển sang trang success
        //redirect  : chuyển hướng sang một URL khác
        //forward : chuyển tiếp yêu cầu đến một URL khác trên server mà không thay đổi URL
        return "redirect:/student/success-page"; // trả vè file home-pages.jsp
    }
    @RequestMapping("/success-pages")
    public String success(){
        return "success"; // trẩ về success.jsp
    }
    // nhận tham số gửi từ request
    @PostMapping("/submit")
    public String submit(@RequestParam("name") String name, @RequestParam("age") int age){
        //@RequestParam : ánh xạ tham số từ request đến tham số của phương thức
        // xử lý dữ liệu
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        return "success"; // trả về result.jsp
    }

    @GetMapping("/{id}")
    public String  getStudent(@PathVariable("id") int id){
        // xử lý dữ liệu
        System.out.println("ID: " + id);
        return "success"; // trả về result.jsp
    }

}

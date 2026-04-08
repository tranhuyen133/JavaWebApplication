package re.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home-page")
    public ModelAndView homePage(ModelMap model) {
        // từ controller gui du liẹu ra giao diẹn
        // model , moldel map , model and view : là các đối tượng để gửi dữ liệu từ controller đến view
        // model, moldel map : là các đối tượng để gửi dữ liệu từ controller đến view, chúng có thể được
        // sử dụng để thêm các thuộc tính vào mô hình dữ liệu mà sau đó có thể được truy cập trong view. Chúng thường được sử dụng trong các phương thức của controller để truyền dữ liệu từ controller đến view.
//        model.put("heigh","1m90");// gửi dữ liệu đến view
//        model.put("weight","80kg");
//            return "home-pages";
        ModelAndView modelAndView = new ModelAndView();
        // viewName : tên của view mà bạn muốn hiển thị
        // Object model : là dữ liệu mà bạn muốn gửi đến view, nó có thể là một đối tượng hoặc một tập hợp các thuộc tính
        modelAndView.addObject("heigh","1m90");
        modelAndView.addObject("weight","80kg");
        return modelAndView;
        }


}

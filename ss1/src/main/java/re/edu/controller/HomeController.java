package re.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import re.edu.utils.InputMethod;

@Controller
public class HomeController {

    private final InputMethod inputMethod;

    public HomeController(InputMethod inputMethod) {
        this.inputMethod = inputMethod;
    }

    @GetMapping("/home")
    public String homePage() {
        System.out.println("input : " + inputMethod.getString());
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/product")
    public String productPage() {
        return "product";
    }
}
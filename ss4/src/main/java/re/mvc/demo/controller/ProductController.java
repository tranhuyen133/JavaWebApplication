package re.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.mvc.service.ProductService;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor // lombok
public class ProductController {
    private final ProductService productService;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.getProductList());
        return "product/list-product";
    }
}
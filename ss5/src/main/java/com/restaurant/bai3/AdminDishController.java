package com.restaurant.bai3;

import com.restaurant.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService service;

    // 👉 Trang edit
    @GetMapping("/bai3/edit/{id}")
    public String editDish(@PathVariable("id") Long id, Model model) {

        Dish dish = service.getById(id);

        // 🔥 Bẫy dữ liệu: không tồn tại
        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            model.addAttribute("dishes", service.getAll());
            return "dish-list"; // quay về list
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}
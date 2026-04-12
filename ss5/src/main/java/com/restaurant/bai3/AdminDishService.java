package com.restaurant.bai3;

import com.restaurant.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {

    private List<Dish> dishes = new ArrayList<>();

    public AdminDishService() {
        dishes.add(new Dish(1L, "Phở bò", 40000, true));
        dishes.add(new Dish(2L, "Bún chả", 35000, true));
        dishes.add(new Dish(3L, "Cơm tấm", 30000, false));
    }

    public Dish getById(Long id) {
        return dishes.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Dish> getAll() {
        return dishes;
    }
}
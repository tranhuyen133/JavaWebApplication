package com.restaurant.bai2;

import com.restaurant.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    public List<Dish> getAllDishes() {
        List<Dish> list = new ArrayList<>();

        list.add(new Dish(1L, "Phở bò", 40000, true));
        list.add(new Dish(2L, "Bún chả", 35000, true));
        list.add(new Dish(3L, "Cơm tấm", 30000, false));

        return list;
    }
}
package bai3.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
// Repository quản lý dữ liệu kho món ăn.
// Chức năng chính: kiểm tra số lượng món và cập nhật số lượng sau khi đặt món thành công.
public class InventoryRepository {

    private final Map<String, Integer> inventory = new HashMap<>();

    public InventoryRepository() {
        // Dữ liệu mẫu trong kho
        inventory.put("Mì tôm", 10);
        inventory.put("Mì xào bò", 0); // bẫy dữ liệu: hết hàng
        inventory.put("Nước ngọt", 5);
    }

    public int getQuantity(String foodName) {
        // Trả về số lượng món ăn trong kho
        // Nếu món không tồn tại thì trả về 0
        return inventory.getOrDefault(foodName, 0);
    }

    public void decreaseQuantity(String foodName, int amount) {
        // Giảm số lượng món trong kho sau khi đặt món thành công
        int current = inventory.getOrDefault(foodName, 0);
        inventory.put(foodName, current - amount);
    }
}

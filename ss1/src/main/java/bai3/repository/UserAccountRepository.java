package bai3.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
// Repository quản lý dữ liệu tài khoản người dùng.
// Chức năng chính: lấy số dư và trừ tiền khi khách đặt món.
public class UserAccountRepository {

    private final Map<String, Double> accounts = new HashMap<>();

    public UserAccountRepository() {
        // Dữ liệu mẫu tài khoản
        accounts.put("huyen", 50000.0);
        accounts.put("an", 10000.0);
        accounts.put("nam", -5000.0); // bẫy dữ liệu: số dư âm
    }

    public double getBalance(String username) {
        // Lấy số dư tài khoản của người dùng
        // Nếu không tồn tại thì mặc định trả về 0
        return accounts.getOrDefault(username, 0.0);
    }

    public void deductBalance(String username, double amount) {
        // Trừ tiền tài khoản khi đặt món thành công
        double current = accounts.getOrDefault(username, 0.0);
        accounts.put(username, current - amount);
    }
}
package bai3.service;

import bai3.repository.InventoryRepository;
import bai3.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
// Service xử lý nghiệp vụ đặt đồ ăn tại máy trạm.
// Class này không tự tạo repository bằng new,
// mà nhận dependency từ Spring thông qua DI để đảm bảo loose coupling.
public class OrderFoodService {

    private final InventoryRepository inventoryRepository;
    private final UserAccountRepository userAccountRepository;

    public OrderFoodService(InventoryRepository inventoryRepository,
                            UserAccountRepository userAccountRepository) {
        // Constructor Injection:
        // Spring sẽ tự tiêm InventoryRepository và UserAccountRepository vào service.
        // Cách này giúp code linh hoạt, dễ bảo trì và dễ test hơn.
        this.inventoryRepository = inventoryRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public void orderFood(String username, String foodName, double price) {
        // Bước 1: kiểm tra số lượng món ăn trong kho
        int quantity = inventoryRepository.getQuantity(foodName);

        // Nếu số lượng <= 0 thì món đã hết hàng, dừng xử lý
        if (quantity <= 0) {
            System.out.println("Món " + foodName + " đã hết hàng");
            return;
        }

        // Bước 2: kiểm tra số dư tài khoản người dùng
        double balance = userAccountRepository.getBalance(username);

        // Nếu số dư âm thì dữ liệu tài khoản không hợp lệ
        if (balance < 0) {
            System.out.println("Tài khoản không hợp lệ vì số dư âm");
            return;
        }

        // Nếu số dư không đủ để thanh toán món ăn thì báo lỗi
        if (balance < price) {
            System.out.println("Tài khoản không đủ số dư để đặt món");
            return;
        }

        // Bước 3: nếu hợp lệ thì trừ tiền tài khoản
        userAccountRepository.deductBalance(username, price);

        // Bước 4: giảm số lượng món trong kho
        inventoryRepository.decreaseQuantity(foodName, 1);

        // Bước 5: thông báo đặt món thành công
        System.out.println("Đặt món thành công: " + foodName + " cho " + username);
        System.out.println("Số tiền đã trừ: " + price);
    }
}

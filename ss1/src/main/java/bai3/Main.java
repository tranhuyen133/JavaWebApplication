package bai3;

import bai3.config.AppConfig;
import bai3.service.OrderFoodService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Tạo Spring IoC Container từ class cấu hình AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Lấy bean OrderFoodService từ container
        // Service này đã được Spring tự inject các repository vào bên trong
        OrderFoodService orderFoodService = context.getBean(OrderFoodService.class);

        System.out.println("=== Trường hợp 1: Hết hàng ===");
        orderFoodService.orderFood("huyen", "Mì xào bò", 25000);

        System.out.println("\n=== Trường hợp 2: Không đủ tiền ===");
        orderFoodService.orderFood("an", "Mì tôm", 25000);

        System.out.println("\n=== Trường hợp 3: Số dư âm ===");
        orderFoodService.orderFood("nam", "Mì tôm", 15000);

        System.out.println("\n=== Trường hợp 4: Thành công ===");
        orderFoodService.orderFood("huyen", "Mì tôm", 15000);
    }
}
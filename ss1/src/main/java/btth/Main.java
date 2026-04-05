package btth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import btth.config.AppConfig;
import btth.service.PlaySessionService;

/*
Input:
- username: tên người dùng
- balance: số dư tài khoản

Output:
- Nếu balance < 5000 -> cảnh báo theo dịch vụ đã được tiêm vào
- Nếu username rỗng/null hoặc balance âm -> log lỗi thân thiện, không crash

Kỹ thuật DI sử dụng:
- Constructor Injection
Lý do:
- Dependency rõ ràng, không dùng new thủ công trong service
- Phù hợp với IoC, dễ bảo trì và dễ kiểm thử
*/

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Lấy bean từ IoC Container để mô phỏng luồng chạy
        PlaySessionService playSessionService = context.getBean(PlaySessionService.class);

        System.out.println("=== Case 1: Bình thường ===");
        playSessionService.checkLowBalance("Huyen", 10000);

        System.out.println("\n=== Case 2: Sắp hết giờ ===");
        playSessionService.checkLowBalance("Huyen", 3000);

        System.out.println("\n=== Case 3: Username rỗng ===");
        playSessionService.checkLowBalance("", 3000);

        System.out.println("\n=== Case 4: Username null ===");
        playSessionService.checkLowBalance(null, 3000);

        System.out.println("\n=== Case 5: Balance âm ===");
        playSessionService.checkLowBalance("Huyen", -1000);
    }
}
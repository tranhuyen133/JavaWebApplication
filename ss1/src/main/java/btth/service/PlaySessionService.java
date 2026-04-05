package btth.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
// Nghiệp vụ:
// - nhận username và balance
// - kiểm tra dữ liệu đầu vào
// - nếu balance < 5000 thì kích hoạt cảnh báo
// Dùng Constructor Injection để Spring tự tiêm dependency,
// tránh khởi tạo bằng new và đảm bảo loose coupling.
public class PlaySessionService {

    private final AlertService alertService;

    public PlaySessionService(@Qualifier("popupAlertService") AlertService alertService) {
        this.alertService = alertService;
    }

    public void checkLowBalance(String username, double balance) {
        // Bắt bẫy dữ liệu đầu vào, không để hệ thống crash
        if (username == null || username.trim().isEmpty()) {
            System.out.println("[LOG] Username không hợp lệ. Không thể kiểm tra cảnh báo.");
            return;
        }

        if (balance < 0) {
            System.out.println("[LOG] Số dư của người dùng " + username + " bị âm. Vui lòng kiểm tra lại dữ liệu đồng bộ.");
            return;
        }

        if (balance < 5000) {
            alertService.alert(username, balance);
        } else {
            System.out.println("[INFO] Tài khoản của " + username + " vẫn đủ số dư: " + balance + " VNĐ.");
        }
    }
}
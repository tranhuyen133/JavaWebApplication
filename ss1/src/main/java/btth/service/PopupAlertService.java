package btth.service;

import org.springframework.stereotype.Component;

@Component("popupAlertService")
// Cảnh báo popup dành cho khu VIP tĩnh lặng
public class PopupAlertService implements AlertService {

    @Override
    public void alert(String username, double balance) {
        System.out.println("[POPUP] Cảnh báo cho " + username + ": Số dư còn " + balance + " VNĐ, vui lòng nạp thêm tiền.");
    }
}

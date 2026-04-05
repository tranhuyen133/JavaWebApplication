package btth.service;

import org.springframework.stereotype.Component;

@Component("soundAlertService")
// Cảnh báo âm thanh dành cho khu thường
public class SoundAlertService implements AlertService {

    @Override
    public void alert(String username, double balance) {
        System.out.println("[SOUND] Phát âm thanh cảnh báo cho " + username + ": Số dư còn " + balance + " VNĐ.");
    }
}

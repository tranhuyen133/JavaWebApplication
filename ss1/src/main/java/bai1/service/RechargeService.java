package bai1.service;

import bai1.payment.InternalPaymentGateway;
import bai1.payment.PaymentGateway;

public class RechargeService {
    private PaymentGateway gateway;

    public RechargeService() {
        // Lỗi:
        // RechargeService đang tự khởi tạo dependency bằng từ khóa new.
        // Điều này làm class bị phụ thuộc chặt vào InternalPaymentGateway
        // và không thể linh hoạt đổi sang Momo hoặc ZaloPay mà không sửa code.
        // Cách viết này vi phạm nguyên lý IoC vì quyền tạo object
        // vẫn nằm trong service thay vì giao cho Container quản lý.
        this.gateway = new InternalPaymentGateway();
    }

    public void processRecharge(String username, double amount) {
        gateway.pay(amount);
        System.out.println("Nạp " + amount + " cho " + username);
    }
}
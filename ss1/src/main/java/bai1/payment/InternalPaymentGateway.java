package bai1.payment;

public class InternalPaymentGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua cổng nội bộ: " + amount);
    }
}

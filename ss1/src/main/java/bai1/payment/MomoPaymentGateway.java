package bai1.payment;

public class MomoPaymentGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua Momo: " + amount);
    }
}
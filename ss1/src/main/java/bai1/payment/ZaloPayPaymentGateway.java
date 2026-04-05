package bai1.payment;

public class ZaloPayPaymentGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua ZaloPay: " + amount);
    }
}
package bai1.service;


import bai1.payment.PaymentGateway;

public class RechargeService {
    private PaymentGateway gateway;

    public RechargeService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void processRecharge(String username, double amount) {
        gateway.pay(amount);
        System.out.println("Nạp " + amount + " cho " + username);
    }
}
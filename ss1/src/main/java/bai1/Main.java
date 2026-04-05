package bai1;

import bai1.payment.MomoPaymentGateway;
import bai1.payment.PaymentGateway;
import bai1.service.RechargeService;

public class Main {
    public static void main(String[] args) {
        PaymentGateway gateway = new MomoPaymentGateway();
        RechargeService rechargeService = new RechargeService(gateway);

        rechargeService.processRecharge("Huyen", 50000);
    }
}

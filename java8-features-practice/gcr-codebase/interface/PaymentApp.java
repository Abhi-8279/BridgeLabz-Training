interface PaymentProcessor {

    void processPayment(double amount);

    // Default method added later (Java 8 feature)
    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed using standard policy");
    }
}

class PaymentService implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed successfully");
    }

    // refund() is NOT mandatory to override
}

public class PaymentApp {
    public static void main(String[] args) {

        PaymentProcessor payment = new PaymentService();

        payment.processPayment(2500);
        payment.refund(1000);
    }
}

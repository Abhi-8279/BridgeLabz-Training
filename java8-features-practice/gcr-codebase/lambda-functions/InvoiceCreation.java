import java.util.Arrays;
import java.util.List;
class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice generated for Transaction ID: " + transactionId;
    }
}

public class InvoiceCreation {

    public static void main(String[] args) {

        List<String> transactionIds =
                Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        List<Invoice> invoices =
                transactionIds.stream()
                              .map(Invoice::new)   // Constructor reference
                              .toList();

        invoices.forEach(System.out::println);
    }
}

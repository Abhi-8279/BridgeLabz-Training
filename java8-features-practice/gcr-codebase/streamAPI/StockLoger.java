import java.util.Arrays;
import java.util.List;

public class StockLoger {

    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(150.25, 152.30, 149.80, 151.90, 153.50, 154.00);
        System.out.println("Live Stock Price Updates:");
        stockPrices.stream().forEach(price -> System.out.println("Stock Price: $" + price));

        // OR using method reference
        // stockPrices.stream().forEach(System.out::println);
//        int th=IoTsensor.thresh;
//        System.out.println(th);
    }
}

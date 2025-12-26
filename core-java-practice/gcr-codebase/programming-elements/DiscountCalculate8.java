import java.util.Scanner;

class DiscountCalculate8 {
    public static void main(String[] args) {

        double fee;
        double discountPercent;
        double discount;
        double finalFee;

        Scanner r = new Scanner(System.in);

        fee = r.nextDouble();
        discountPercent = r.nextDouble();

        discount = (fee * discountPercent) / 100;
        finalFee = fee - discount;

        System.out.println(
            "The discount amount is INR " + discount +
            " and final discounted fee is INR " + finalFee
        );
    }
}


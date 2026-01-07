import java.util.*;
//Interface
interface Discountable{
	double applyDiscount();
	void getDiscountDetails();
}
//abstract class
abstract class FoodItem{
	private String itemName;
    private double price;
    private int quantity;
    //constructor
    FoodItem(String itemName,double price,int quantity){
    	this.itemName = itemName;
    	this.price = price;
    	this.quantity = quantity;
    }
	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	//abstract method 
	abstract double calculateTotalPrice();
	//concrete methods 
	public void getItemDetails(){
		System.out.println("Item Name: "+itemName);
	}	
}
class VegItem extends FoodItem implements Discountable{

	VegItem(String itemName, double price, int quantity) {
		super(itemName, price, quantity);
		
	}

	@Override
	double calculateTotalPrice() {
		
		return getPrice()*getQuantity();
	}

	@Override
	public double applyDiscount() {
		return calculateTotalPrice()*0.10;
	}

	@Override
	public void getDiscountDetails() {
		System.out.println("Veg Item Discount: 10% ");	
	}	
}
class NonVegItem extends FoodItem implements Discountable{

	private final double extraCharge = 50;
	NonVegItem(String itemName, double price, int quantity) {
		super(itemName, price, quantity);
	}

	@Override
	public double applyDiscount() {
		return calculateTotalPrice()*0.05;
	}

	@Override
	public void getDiscountDetails() {
		System.out.println("NonVeg Item Discount: 5%");
		
	}

	@Override
	double calculateTotalPrice() {
		return ((getPrice()*getQuantity())+ (extraCharge*getQuantity()));
	}
	
}
public class FoodDeliverySystem {
	public static void processOrder(List<FoodItem> foodItems) {
		double grandTotal =0;
		for(FoodItem item:foodItems) {
			item.getItemDetails();
			double total = item.calculateTotalPrice();
			double discount =0;
			if(item instanceof Discountable) {
				Discountable d = (Discountable) item;
                discount = d.applyDiscount();
                d.getDiscountDetails();
			}
			double finalPrice = total - discount;
            grandTotal += finalPrice;

            System.out.println("Total Price: ₹" + total);
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("--------------------------");
		}
		System.out.println("Grand Total Bill: ₹" + grandTotal);
	}
	 public static void main(String[] args) {

	        List<FoodItem> order = new ArrayList<>();

	        order.add(new VegItem("Paneer Butter Masala", 250, 2));
	        order.add(new NonVegItem("Chicken Biryani", 300, 1));
	        order.add(new VegItem("Butter Naan", 40, 4));

	        processOrder(order);
	 }
}
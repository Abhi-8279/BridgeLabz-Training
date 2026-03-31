

import java.util.ArrayList;
import java.util.List;
//interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
//abstract method
abstract class Product{
	private int productID;
	String name;
	private double price;
	
	Product(int productID,String name,double price){
		this.setProductID(productID);
		this.name = name;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price > 0) {     // validation
            this.price = price;
        }
    }
	public abstract double calculateDiscount();
	public void getProductDetails() {
		System.out.println("Product Id: "+productID);
		System.out.println("Product Name: "+name);
		System.out.println("Price: "+price);
	}
}
class Electronics extends Product implements Taxable{

	Electronics(int productID, String name, double price) {
		super(productID, name, price);
	}

	@Override
	public double calculateDiscount() {
		return (getPrice()* 0.10);
	}

	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return getPrice() * 0.18;
	}

	@Override
	public String getTaxDetails() {
		// TODO Auto-generated method stub
		return "Electronics GST: 18%";
	}	
}
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing GST: 5%";
    }
}
class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
 
 public class Ecommerce {

	public static void calculateFinalPrice(List<Product> products) {

        for (Product p : products) {

            double tax = 0;

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                System.out.println(((Taxable) p).getTaxDetails());
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            p.getProductDetails();
            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("--------------------------");
        }
    }
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "T-Shirt", 2000));
        products.add(new Groceries(103, "Rice", 1000));

        calculateFinalPrice(products);
	}
}
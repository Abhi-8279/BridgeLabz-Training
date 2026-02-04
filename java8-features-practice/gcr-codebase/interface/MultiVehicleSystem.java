interface rental
{
	void rent(); 
	void returnVehicle();
}

class Car implements rental
{
	public void rent()
	{
		System.out.println("The Rent of car is 300/day");
	}
	public void returnVehicle()
	{
		System.out.println("The return period is within 24Hr.");
	}
	
	
}
class Bike implements rental
{
	public void rent()
	{
		System.out.println("The Rent of bike is 180/day");
	}
	public void returnVehicle()
	{
		System.out.println("The return period is within 12Hr.");
	}
	
}
class Bus implements rental
{
	public void rent()
	{
		System.out.println("The Rent of BUS is 1000/day");
	}
	public void returnVehicle()
	{
		System.out.println("The return period of bus is  within 24Hr.");
	}
	
}

public class MultiVehicleSystem {
	public static void main(String[] args) {
		rental cr=new Car();
		cr.rent();
		cr.returnVehicle();
		rental bs=new Bus();
		bs.rent();
		bs.returnVehicle();
		rental bk=new Bike();
		bk.rent();
		bk.returnVehicle();
		
	}

}

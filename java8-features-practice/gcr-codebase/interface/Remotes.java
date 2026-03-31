interface control
{
	void turnOff();
	void turnOn();
}

class Remote implements control{
	
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Remote Off");
		
	}
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Remote ON");
	}

}
class Tv implements control
{
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println(" TV Remote Off");
	}
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println(" TV Remote ON");
	}
	
}
class Ac implements control
{
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("AC Remote Off");
	}
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("AC Remote On");
	}
}
public class Remotes 
{
	public static void main(String[] args) {
		 control ac = new Ac();
	        control tv = new Tv();
		ac.turnOn();
		ac.turnOff();
		tv.turnOn();
		tv.turnOff();
	}
	
}

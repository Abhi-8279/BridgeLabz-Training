package jar;


public class ExceptionHandle {
	public static int divide(int a, int b) {
		if(b==0) {
			throw new ArithmeticException("Division by 0 not possible.");
		}
		return a/b;
	}
}
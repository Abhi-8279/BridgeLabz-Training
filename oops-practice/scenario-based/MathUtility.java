public class MathUtility {
    // factorial program
    static long factorial(int num){
         if(num<0) return -1;

        long fact=1;
        for(int i =1;i<=num;i++){
            fact *= i;
        }
        return fact;
    }

    //Prime check
    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;

        return true;
    }

     // GCD method (Euclidean algorithm)
    static int gcd(int a, int b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Fibonacci method
    static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("Factorial(5): " + factorial(5));
        System.out.println("Factorial(-3): " + factorial(-3));

        System.out.println("IsPrime(7): " + isPrime(7));
        System.out.println("IsPrime(1): " + isPrime(1));

        System.out.println("GCD(48, 18): " + gcd(48, 18));
        System.out.println("GCD(-12, 8): " + gcd(-12, 8));

        System.out.println("Fibonacci(7): " + fibonacci(7));
        System.out.println("Fibonacci(-2): " + fibonacci(-2));
    }
}

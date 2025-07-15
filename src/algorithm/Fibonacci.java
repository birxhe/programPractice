package algorithm;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(20));
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        } else {
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }
}

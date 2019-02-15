/*
 * Title: Fibonacci
 * Author: Sam Gavis-Hughson
 * Date: 2/15/19
 * 
 * Given an integer n, find the nth Fibonacci number
 * 
 * eg. 
 * fib(8) = 21
 * 
 * Execution: javac CountEven.java && java CountEven
 */


public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }
}
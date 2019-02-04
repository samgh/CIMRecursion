public class GCD {
    public static int gcd(int a, int b) {
        if (b > a) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println(gcd(10, 5));
        System.out.println(gcd(5, 10));
        System.out.println(gcd(10, 1));
        System.out.println(gcd(1, 5));
    }
}
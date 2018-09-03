public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        return s.charAt(0) == s.charAt(s.length() - 1) 
            && isPalindrome(s.substring(1, s.length()-1));
    }
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abccba"));
        System.out.println(isPalindrome("abcdba"));
        System.out.println(isPalindrome("abccbb"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome(""));
    }
}
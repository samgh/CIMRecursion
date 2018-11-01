/*
 * Title: Is Palindrome
 * Author: Sam Gavis-Hughson
 * Date: 11/1/2018
 * 
 * Given a string, determine whether or not the string is a palindrome.
 * 
 * Execution: javac IsPalindrome.java && java IsPalindrome
 */

public class IsPalindrome {
    
    // Recursively determine if a string is a palindrome. If the outer two chars
    // are the same, then remove them and recursively move towards the center
    public static boolean isPalindrome(String s) {
        // We could end up with 1 or 0 chars, either of which is a palindrome
        if (s.length() <= 1) return true;
        
        // If the outer two characters are the same, remove them and move
        // inward. Otherwise its not a palindrome
        return s.charAt(0) == s.charAt(s.length() - 1) 
            && isPalindrome(s.substring(1, s.length()-1));
    }
    
    // Recursively determine if string is a palindrome. Optimized by tracking
    // indices rather than creating new substrings
    public static boolean isPalindromeOptimized(String s) {
        return isPalindromeOptimized(s, 0, s.length() - 1);
    }
    
    // Recursive inner function
    private static boolean isPalindromeOptimized(String s, int start, int end) {
        // If the start and end are the same or end is less, then palindrome
        if (end - start <= 0) return true;
        
        // Same as nonoptimal version, except update indices instead
        return s.charAt(start) == s.charAt(end) 
            && isPalindromeOptimized(s, start+1, end-1);
    }
    
    // Sample test cases
    public static void main(String[] args) {
        System.out.println(isPalindromeOptimized("abcba"));
        System.out.println(isPalindromeOptimized("abccba"));
        System.out.println(isPalindromeOptimized("abcdba"));
        System.out.println(isPalindromeOptimized("abccbb"));
        System.out.println(isPalindromeOptimized("a"));
        System.out.println(isPalindromeOptimized(""));
    }
}
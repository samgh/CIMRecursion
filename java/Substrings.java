/*
 * Title: Substrings
 * Author: Sam Gavis-Hughson
 * Date: 11/1/2018
 * 
 * Given a String, write a function that returns a list of all of the substrings.
 * 
 * substrings("abcd") = {"a", "ab", "abc", "abcd", "b", "bc", "bcd", "c", "cd", "d"}
 * 
 * Execution: javac Substrings.java && java Substrings
 */

import java.util.LinkedList;
import java.util.List;

public class Substrings {
    
    // Iteratively generate all substrings using a nested for loop
    public static List<String> substringsIterative(String s) {
        List<String> result = new LinkedList<String>();
        // Iterate over possible starting indices
        for (int i = 0; i < s.length(); i++) {
            // Iterate over possible ending indices
            for (int j = i+1; j <= s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }
        
        return result;
    }
    
    // Recursively generate all substrings using one recursive function for each
    // for loop
    public static List<String> substringsRecursive(String s) {
        List<String> result = new LinkedList<String>();
        substringsRecursive(s, 0, result);
        return result;
    }
    
    // Recursively iterate over all possible starting characters
    private static void substringsRecursive(String s, int i, List<String> result) {
        if (i >= s.length()) return;
        substringsRecursiveInner(s, i, i+1, result);
        substringsRecursive(s, i+1, result);
    }
    
    // Recursively iterate over all possible ending characters
    private static void substringsRecursiveInner(String s, int i, int j, List<String> result) {
        if (j > s.length()) return;
        result.add(s.substring(i, j));
        substringsRecursiveInner(s, i, j+1, result);
    }
    
    // Recursively generate all substrings with a single recursive function. We
    // increment either i or j but have to make sure that we don't include the
    // same substring multiple times
    public static List<String> substringsRecursive2(String s) {
        List<String> result = new LinkedList<String>();
        substringsRecursive2(s, 0, 1, result);
        return result;
    }
    
    // Inner recursive function
    private static void substringsRecursive2(String s, int i, int j, List<String> result) {
        if (i >= s.length() || j > s.length()) return;
        
        // This condition ensures that we only include each substring once.
        // There are many options here. i+1 == j also works
        if (j == s.length()) substringsRecursive2(s, i+1, i+2, result);
        substringsRecursive2(s, i, j+1, result);

        result.add(s.substring(i, j));
    }

    // Sample test cases
    public static void main(String[] args) {
        System.out.println(substringsIterative("abcd"));
        System.out.println(substringsRecursive2("abcd"));
    }
}
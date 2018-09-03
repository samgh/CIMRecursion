import java.util.LinkedList;
import java.util.List;

public class Substrings {
    public static List<String> substringsIterative(String s) {
        List<String> result = new LinkedList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                result.add(s.substring(i, j));
            }
        }
        
        return result;
    }
    
    public static List<String> substringsRecursive(String s) {
        List<String> result = new LinkedList<String>();
        substringsRecursive(s, 0, result);
        return result;
    }
    
    public static void substringsRecursive(String s, int i, List<String> result) {
        if (i >= s.length()) return;
        substringsRecursiveInner(s, i, i+1, result);
        substringsRecursive(s, i+1, result);
    }
    
    public static void substringsRecursiveInner(String s, int i, int j, List<String> result) {
        if (j > s.length()) return;
        result.add(s.substring(i, j));
        substringsRecursiveInner(s, i, j+1, result);
    }
    
    public static List<String> substringsRecursive2(String s) {
        List<String> result = new LinkedList<String>();
        substringsRecursive2(s, 0, 1, result);
        return result;
    }
    
    private static void substringsRecursive2(String s, int i, int j, List<String> result) {
        if (i >= s.length() || j > s.length()) return;
        
        if (i+1 == j) substringsRecursive2(s, i+1, i+2, result);
        substringsRecursive2(s, i, j+1, result);

        result.add(s.substring(i, j));
    }

    public static void main(String[] args) {
        System.out.println(substringsIterative("abcd"));
        System.out.println(substringsRecursive2("abcd"));
    }
}
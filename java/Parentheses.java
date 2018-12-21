import java.util.LinkedList;
import java.util.List;

public class Parentheses {
    public static List<String> parentheses(String s) {
        if (s.length() == 1) {
            List<String> result = new LinkedList<String>();
            result.add(s);
            return result;
        }
        
        List<String> results = new LinkedList<String>();
        
        for (int i = 1; i < s.length(); i++) {
            List<String> left = parentheses(s.substring(0, i));
            List<String> right = parentheses(s.substring(i, s.length()));
            
            for (String s1 : left) {
                for (String s2 : right) {
                    results.add("(" + s1 + s2 + ")");
                }
            }
        }
        
        return results;
    }
    
    public static void main(String[] args) {
//        System.out.println(parentheses("abc"));
        System.out.println(parentheses("abcdefghijkl").size());
    }
}
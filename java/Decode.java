import java.util.List;
import java.util.LinkedList;

public class Decode {  
    public static List<String> decode(String s) {
        List<String> result = new LinkedList<String>();
        decode(s, 0, new StringBuilder(), result);
        return result;
    }
    
    private static void decode(String s, int i, StringBuilder curr, List<String> result) {
        if (i >= s.length()) {
            result.add(curr.toString());
            return;
        }
        
        for (char c : getNext(s, i)) {
            curr.append(c);
            
            if (c < 'A'+10) {
                decode(s, i+1, curr, result);
            } else {
                decode(s, i+2, curr, result);
            }
            curr.setLength(curr.length() - 1);
        }
    }
    
    private static List<Character> getNext(String s, int i) {
        List<Character> toReturn = new LinkedList<Character>();
        int val = Integer.valueOf(s.substring(i, i+1));
        toReturn.add((char) ('A' + val - 1));
        if (i < s.length() - 1) {
            val = Integer.valueOf(s.substring(i, i+2));
            if (val <= 26) toReturn.add((char) ('A' + val - 1));
        }
        return toReturn;
    }
    
    public static void main(String[] args) {
        System.out.println(decode("223"));
        System.out.println(decode("227"));
        System.out.println(decode("4231123"));
    }
}
import java.util.LinkedList;
import java.util.List;
//import java.util.StringBuilder;

public class InterleaveStrings {
    public static List<String> interleaveBruteForce(String s1, String s2) {
        int[] toCombine = new int[s1.length() + s2.length()];
        for (int i = 0; i < toCombine.length; i++) toCombine[i] = i;
        List<List<Integer>> positions = 
            CombinationsOfLength.combinationsOfLengthBacktracking(toCombine, s1.length());
        
        List<String> results = new LinkedList<String>();
        
        for (List<Integer> l : positions) {
            int i = 0;
            int j = 0;
            StringBuilder result = new StringBuilder();
            for (int k = 0; k < s1.length() + s2.length(); k++) {
                if (l.contains(k)) result.append(s1.charAt(i++));
                else result.append(s2.charAt(j++));
            }
            
            results.add(result.toString());
        }
        return results;
    }
    
    public static List<String> interleave(String s1, String s2) {
        List<String> results = new LinkedList<String>();
        interleave(s1, s2, 0, 0, new StringBuilder(), results);
        return results;
    }
    
    private static void interleave(String s1, String s2, int i, int j, 
                                   StringBuilder path, List<String> results) {
        if (i == s1.length() && j == s2.length()) {
            results.add(path.toString());
            return;
        }
        
        if (i < s1.length()) {
            path.append(s1.charAt(i));
            interleave(s1, s2, i+1, j, path, results);
            path.setLength(path.length() - 1);
        }
        if (j < s2.length()) {        
            path.append(s2.charAt(j));
            interleave(s1, s2, i, j+1, path, results);
            path.setLength(path.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(interleaveBruteForce("ab", "cd"));
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class WordBreak {
    public static List<String> wordBreak(String s, Set<String> dict) {
        List<String> results = new LinkedList<String>();
        wordBreak(new ArrayList<String>(), s, dict, results);
        return results;
    }
    
    private static void wordBreak(List<String> curr, String remainder, 
                           Set<String> dict, List<String> results) {
        if (remainder.length() == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < curr.size() - 1; i++) {
                sb.append(curr.get(i) + " ");
            }
            sb.append(curr.get(curr.size() - 1));
            results.add(sb.toString());
            return;
        }
        
        for (int i = 1; i <= remainder.length(); i++) {
            String substr = remainder.substring(0, i);
            if (dict.contains(substr)) {
                curr.add(substr);
                wordBreak(curr, remainder.substring(i, remainder.length()), dict, results);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", 
                                     new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }
}
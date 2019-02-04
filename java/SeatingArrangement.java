import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SeatingArrangement {
    public static List<List<Integer>> arrangements(int N, Map<Integer, Integer> pairs) {
        Set<Integer> remaining = new HashSet<Integer>();
        for (int i = 1; i <= N; i++) remaining.add(i);
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        arrangements(remaining, pairs, new LinkedList<Integer>(), results);
        return results;
    }
    
    private static void arrangements(Set<Integer> remaining, Map<Integer, Integer> pairs, 
                                     List<Integer> path, List<List<Integer>> results) {
        if (remaining.isEmpty()) {
            results.add(new LinkedList<Integer>(path));
            return;
        }
        
        for (Integer i : remaining.toArray(new Integer[]{})) {
            remaining.remove(i);
            path.add(i);
            
            Integer j = pairs.get(i);
            if (j != null) {
                remaining.remove(j);
                path.add(j);
            }
            
            arrangements(remaining, pairs, path, results);
            
            remaining.add(i);
            path.remove(path.size() - 1);
            
            if (j != null) {
                remaining.add(j);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        pairs.put(1, 3);
        pairs.put(3, 1);
        
        System.out.println(arrangements(3, pairs));
    }
}
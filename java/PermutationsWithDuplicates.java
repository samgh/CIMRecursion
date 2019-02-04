import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermutationsWithDuplicates {
    public static List<List<Integer>> permutationsWithDuplicates(List<Integer> items) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        HashMap<Integer, Integer> itemCounts = new HashMap<Integer, Integer>();
        for (int i : items) {
            if (itemCounts.containsKey(i)) {
                itemCounts.put(i, itemCounts.get(i) + 1);
            } else {
                itemCounts.put(i, 1);
            }
        }
        permutationsWithDuplicates(itemCounts, new LinkedList<Integer>(), results);
        return results;
    }
    
    private static void permutationsWithDuplicates(Map<Integer, Integer> itemCounts, List<Integer> path, 
                                    List<List<Integer>> results) {
        if (itemCounts.isEmpty()) {
            results.add(new LinkedList<Integer>(path));
            return;
        }
        
        for (Integer i : new HashSet<Integer>(itemCounts.keySet())) {
            int curr = itemCounts.get(i);
            if (curr == 1) {
                itemCounts.remove(i);
            } else {
                itemCounts.put(i, curr - 1);
            }
            
            path.add(i);
            permutationsWithDuplicates(itemCounts, path, results);
            itemCounts.put(i, curr);
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(permutationsWithDuplicates(Arrays.asList(new Integer[]{1,1,1,1,1})));
    }
}
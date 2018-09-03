import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static List<List<Integer>> permutations(Set<Integer> items) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        permutations(items, new LinkedList<Integer>(), results);
        return results;
    }
    
    private static void permutations(Set<Integer> items, List<Integer> path, 
                                    List<List<Integer>> results) {
        if (items.isEmpty()) {
            results.add(new LinkedList<Integer>(path));
            return;
        }
        
        for (Integer i : items.toArray(new Integer[]{})) {
            items.remove(i);
            path.add(i);
            permutations(items, path, results);
            items.add(i);
            path.remove(path.size() - 1);
        }
    }
    
    public static List<List<Integer>> permutationsSwap(int[] items) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        permutationsSwap(items, 0, new LinkedList<Integer>(), results);
        return results;
    }
    
    private static void permutationsSwap(int[] items, int i, List<Integer> path, 
                                     List<List<Integer>> results) {
        if (i == items.length) {
            results.add(new LinkedList<Integer>(path));
            return;
        }
        
        for (int j = i; j < items.length; j++) {
            swap(items, i, j);
            path.add(items[i]);
            permutationsSwap(items, i+1, path, results);
            swap(items, i, j);
            path.remove(path.size() - 1);
        }
    }
    
    private static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    
    public static void main(String[] args) {
        System.out.println(permutations(new HashSet<Integer>(Arrays.asList(new Integer[]{1,2,3}))));
        System.out.println(permutationsSwap(new int[]{1,2,3}));
    }
}
import java.util.List;
import java.util.LinkedList;

public class Combinations {
    static List<List<Integer>> results;
    public static void combinationsGlobal(int[] n) {
        results = new LinkedList<List<Integer>>();
        combinationsGlobal(n, 0, new LinkedList<Integer>());
    }
    
    private static void combinationsGlobal(int[] n, int i,  List<Integer> path) {
        if (i == n.length) {
            results.add(path);
            return;
        }
        List<Integer> pathWithCurrent = new LinkedList(path);
        pathWithCurrent.add(n[i]);
        // Find all the combinations that exclude current item
        combinationsGlobal(n, i+1, path);
        // Find all the combinations that include current item
        combinationsGlobal(n, i+1, pathWithCurrent);
    }
    
    public static List<List<Integer>> combinationsPassed(int[] n) {
        List<List<Integer>> results = new LinkedList();
        combinationsPassed(n, 0, results, new LinkedList<Integer>());
        return results;
    }
    
    private static void combinationsPassed(int[] n, int i, List<List<Integer>> results, List<Integer> path) {
        if (i == n.length) {
            results.add(path);
            return;
        }
        List<Integer> pathWithCurrent = new LinkedList(path);
        pathWithCurrent.add(n[i]);
        // Find all the combinations that exclude current item
        combinationsPassed(n, i+1, results, path);
        // Find all the combinations that include current item
        combinationsPassed(n, i+1, results, pathWithCurrent);
    }
    
    
    public static List<List<Integer>> combinationsBuiltUp(int[] n) {
        return combinationsBuiltUp(n, 0);
    }
    
    private static List<List<Integer>> combinationsBuiltUp(int[] n, int i) {
        if (i == n.length) {
            List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
            toReturn.add(new LinkedList<Integer>());
            return toReturn;
        }
        
        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
        for (List<Integer> result : combinationsBuiltUp(n, i+1)) {
            // Exclude current item
            toReturn.add(new LinkedList<Integer>(result));
            // Include current item
            result.add(0, n[i]);
            toReturn.add(new LinkedList<Integer>(result));
        }
        
        return toReturn;
    }
    
    public static void main(String[] args) {
        combinationsGlobal(new int[]{1,2,3});
        System.out.println(results);
        System.out.println(combinationsPassed(new int[]{1,2,3}));
        System.out.println(combinationsBuiltUp(new int[]{1,2,3}));
    }
}
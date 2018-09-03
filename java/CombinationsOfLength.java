import java.util.LinkedList;
import java.util.List;

public class CombinationsOfLength {
    public static List<List<Integer>> combinationsOfLengthBruteForce(int[] n, int length) {
        List<List<Integer>> allCombinations = Combinations.combinationsBuiltUp(n);
        
        List<List<Integer>> filtered = new LinkedList<List<Integer>>();
        for (List<Integer> l : allCombinations) {
            if (l.size() == length) filtered.add(l);
        }
        
        return filtered;
    }
    
    public static List<List<Integer>> combinationsOfLengthBacktracking(int[] n, int length) {
        return combinationsOfLengthBacktracking(n, 0, length, 0);
    }
    
    private static List<List<Integer>> combinationsOfLengthBacktracking(int[] n, int i, 
                                                                       int targetLength, 
                                                                       int currentLength) {
        if (currentLength > targetLength) return new LinkedList<List<Integer>>();
        if (i == n.length && currentLength != targetLength) return new LinkedList<List<Integer>>();
        if (i == n.length) {
            List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
            toReturn.add(new LinkedList<Integer>());
            return toReturn;
        }
        
        List<List<Integer>> include = combinationsOfLengthBacktracking(n, i+1, targetLength, currentLength + 1);
        List<List<Integer>> exclude = combinationsOfLengthBacktracking(n, i+1, targetLength, currentLength);
        
        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
        for (List<Integer> result : include) {
            result.add(0, n[i]);
            toReturn.add(result);
        }
        
        toReturn.addAll(exclude);
        
        return toReturn;
    }
    
//        private static List<List<Integer>> combinationsBuiltUp(int[] n, int i) {
//        if (i == n.length) {
//            List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
//            toReturn.add(new LinkedList<Integer>());
//            return toReturn;
//        }
//        
//        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
//        for (List<Integer> result : combinationsBuiltUp(n, i+1)) {
//            // Exclude current item
//            toReturn.add(new LinkedList<Integer>(result));
//            // Include current item
//            result.add(0, n[i]);
//            toReturn.add(new LinkedList<Integer>(result));
//        }
//        
//        return toReturn;
//    }
    
    public static void main(String[] args) {
        System.out.println(combinationsOfLengthBruteForce(new int[]{1,2,3,4,5}, 3));
        System.out.println(combinationsOfLengthBacktracking(new int[]{1,2,3,4,5}, 3));
    }
}
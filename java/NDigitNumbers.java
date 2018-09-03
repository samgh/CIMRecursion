import java.util.LinkedList;
import java.util.List;

public class NDigitNumbers {
    public static List<Integer> nDigitNumbers(int N, int target) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        nDigitNumbers(N, target, 0, new LinkedList<Integer>(), results);
        
        List<Integer> toReturn = new LinkedList<Integer>();
        for (List<Integer> l : results) {
            toReturn.add(listToInteger(l));
        }
        
        return toReturn;
    }
    
    private static void nDigitNumbers(int N, int target, int sum, 
                                      List<Integer> path, List<List<Integer>> results) {
        if (sum > target) return;
        if (N == 0) {
            if (sum == target) {
                results.add(new LinkedList<Integer>(path));
            }
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            if (sum == 0 && i == 0) continue;
            path.add(i);
            nDigitNumbers(N-1, target, sum+i, path, results);
            path.remove(path.size() - 1);
        }
    }
    
    private static int listToInteger(List<Integer> l) {
        int sum = 0;
        for (int i = 0; i < l.size(); i++) {
            sum += l.get(i) * Math.pow(10, l.size()-i-1);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(nDigitNumbers(5, 12));
    }
}
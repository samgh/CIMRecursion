import java.util.LinkedList;
import java.util.List;

public class StairStep {
    public static int stairStepCount(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        
        return stairStepCount(n-1) + stairStepCount(n-2) + stairStepCount(n-3);
    }
    
    public static List<List<Integer>> stairStep(int n) {
        if (n == 0) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        if (n < 0) {
            return new LinkedList<List<Integer>>();
        }
        
        List<List<Integer>> result = 
            new LinkedList<List<Integer>>(stairStep(n-1));
        result.addAll(stairStep(n-2));
        result.addAll(stairStep(n-3));
        
        for (List<Integer> l : result) {
            l.add(n);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(stairStepCount(3));
        System.out.println(stairStepCount(5));
    }
}
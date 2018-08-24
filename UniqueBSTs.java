import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueBSTs {
    public static int countBSTs(int n) {
        if (n <= 1) return 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += countBSTs(i) * countBSTs(n-i-1);
        }
        
        return count;
    }
    
    public static List<List<Integer>> uniqueBSTs(int n) {
        return uniqueBSTs(0, n);
    }
    
    private static List<List<Integer>> uniqueBSTs(int min, int max) {
        if (min == max) {
            List<List<Integer>> temp = new LinkedList<List<Integer>>();
            temp.add(Arrays.asList(min));
            return temp;
        }
        
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = min; i < max; i++) {
            List<List<Integer>> left = uniqueBSTs(min, i);
            List<List<Integer>> right = uniqueBSTs(i+1, max);
            
            for (List<Integer> l1 : left) {
                for (List<Integer> l2 : right) {
                    List<Integer> temp = new LinkedList<Integer>();
                    temp.add(i);
                    temp.addAll(l1);
                    temp.addAll(l2);
                    result.add(temp);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(countBSTs(3));
        System.out.println(countBSTs(4));
    }
}
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FilterBuiltinList {
    public static void filterListIterative(List<Integer> l, int cutoff) {
        for (int i = l.size() - 1; i >= 0; i--) {
            if (l.get(i) > cutoff) l.remove(i);
        }
    }
    
    public static void filterListRecursive(List<Integer> l, int cutoff) {
        filterListRecursive(l, cutoff, 0);
    }
    
    private static void filterListRecursive(List<Integer> l, int cutoff, int i) {
        if (i >= l.size()) return;
        filterListRecursive(l, cutoff, i+1);
        if (l.get(i) > cutoff) l.remove(i);
    }
    
    public static void main(String[] args) { 
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,4,3,2,1}));
        List<Integer> l2 = new ArrayList(l1);
        filterListIterative(l1, 3);
        filterListRecursive(l2, 3);
        System.out.println("Iterative: " + l1);
        System.out.println("Recursive: " + l2);
    }
}
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sublists {
    public static List<List<Integer>> sublistsIterative(List<Integer> l) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < i; j++) {
                result.add(new LinkedList<Integer>(l.subList(j, i)));
            }
        }
        return result;
    }
    
    public static List<List<Integer>> sublistsRecursive(List<Integer> l) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        sublistsRecursive(l, 0, result);
        return result;
    }

    private static void sublistsRecursive(List<Integer> l, int i, List<List<Integer>> result) {
        if (i >= l.size()) return;
        sublistsRecursiveInner(l, i, 0, result);
        sublistsRecursive(l, i+1, result);
    }
    
    private static void sublistsRecursiveInner(List<Integer> l, int i, int j, List<List<Integer>> result) {
        if (j >= i) return;
        result.add(new LinkedList<Integer>(l.subList(j, i)));
        sublistsRecursiveInner(l, i, j+1, result);
    }
    
    public static void main(String[] args) {
        System.out.println(sublistsIterative(Arrays.asList(1,2,3,4,5)));
        System.out.println(sublistsRecursive(Arrays.asList(1,2,3,4,5)));
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllBSTOrders {
    public static class Node {
        int val;
        Node left;
        Node right;
    }
    
    public static List<List<Integer>> allBSTOrdersDC(Node root) {
        if (root == null) {
            List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
            toReturn.add(new ArrayList<Integer>());
            return toReturn;
        }
        
        List<List<Integer>> left = allBSTOrdersDC(root.left);
        List<List<Integer>> right = allBSTOrdersDC(root.right);
        
        List<List<Integer>> merged = mergeAll(left, right);
        
        for (List<Integer> l : merged) {
            l.add(0, root.val);
        }
        
        return merged;
    }
    
    private static List<List<Integer>> mergeAll(List<List<Integer>> first, 
                                                List<List<Integer>> second) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> f : first) {
            for (List<Integer> s : second) {
                merge(f, s, 0, 0, new ArrayList<Integer>(), result);
            }
        }
        return result;
    }
    
    private static void merge(List<Integer> first, List<Integer> second, 
                                             int i, int j, List<Integer> path, 
                                             List<List<Integer>> result) {
        if (i == first.size() && j == second.size()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        if (i != first.size()) {
            path.add(first.get(i));
            merge(first, second, i+1, j, path, result);
            path.remove(path.size() - 1);
        }
        
        if (j != second.size()) {
            path.add(second.get(j));
            merge(first, second, i, j+1, path, result);
            path.remove(path.size() - 1);
        }
    }
    
    public static List<List<Integer>> allBSTOrdersOrdering(Node root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        allBSTOrdersOrdering(new HashSet<Node>(Arrays.asList(root)), 
                             new ArrayList<Integer>(), results);
        return results;
    }
    
    private static void allBSTOrdersOrdering(Set<Node> available, List<Integer> path, 
                                             List<List<Integer>> results) {
        if (available.isEmpty()) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (Node n : available.toArray(new Node[]{})) {
            available.remove(n);
            if (n.left != null) available.add(n.left);
            if (n.right != null) available.add(n.right);
            path.add(n.val);
            
            allBSTOrdersOrdering(available, path, results);
            
            path.remove(path.size() - 1);
            if (n.left != null) available.remove(n.left);
            if (n.right != null) available.remove(n.right);
            available.add(n);
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node();
        root.val = 5;
        root.left = new Node();
        root.left.val = 3;
        root.right = new Node();
        root.right.val = 8;
        root.left.left = new Node();
        root.left.left.val = 2;
        root.left.right = new Node();
        root.left.right.val = 4;
        System.out.println(allBSTOrdersDC(root));
        System.out.println(allBSTOrdersOrdering(root));
    }
}
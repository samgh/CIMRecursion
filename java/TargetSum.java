import java.util.LinkedList;
import java.util.List;

public class TargetSum {
    public static List<List<Integer>> targetSum(int[] arr, int target) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        targetSum(arr, target, 0, new LinkedList<Integer>(), results);
        return results;
    }
    
    private static void targetSum(int[] arr, int target, int i, List<Integer> path, List<List<Integer>> results) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new LinkedList<Integer>(path));
            return;
        }
        
        if (i == arr.length) return;
        
        path.add(arr[i]);
        targetSum(arr, target-arr[i], i, path, results);
        path.remove(path.size() - 1);
        targetSum(arr, target, i+1, path, results);
    }
    
    public static void main(String[] args) {
        System.out.println(targetSum(new int[]{1,2,3}, 4));
    }
}
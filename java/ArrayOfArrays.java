import java.util.LinkedList;
import java.util.List;

public class ArrayOfArrays {
    public static List<List<Integer>> arrayOfArrays(int[][] arr) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        arrayOfArrays(arr, 0, new LinkedList<Integer>(), results);
        return results;
    }
    
    private static void arrayOfArrays(int[][] arr, int i, List<Integer> path, 
                                      List<List<Integer>> results) {
        if (i == arr.length) {
            results.add(new LinkedList<Integer>(path));
            return;
        }
        
        for (int j : arr[i]) {
            path.add(j);
            arrayOfArrays(arr, i+1, path, results);
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(arrayOfArrays(new int[][]{new int[]{1,2}, new int[]{3}, new int[]{4,5}}));
    }
}
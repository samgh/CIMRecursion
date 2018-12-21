import java.util.LinkedList;
import java.util.List;

public class FlattenArrays {
    public static List<Integer> flattenArraysIterative(int[][] arr) {
        List<Integer> result = new LinkedList<Integer>();
        for (int[] a : arr) {
            for (int i : a) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    public static List<Integer> flattenArrays(int[][] arr) {
        List<Integer> result = new LinkedList<Integer>();
        flattenArrays(arr, 0, 0, result);
        return result;
    }
    
    private static void flattenArrays(int[][] arr, int i, int j, List<Integer> result) {
        if (i == arr.length) return;
        if (j == arr[i].length) {
            flattenArrays(arr, i+1, 0, result);
            return;
        }
        result.add(arr[i][j]);
        flattenArrays(arr, i, j+1, result);
    }
    
    public static void main(String[] args) {
        System.out.println(flattenArraysIterative(new int[][]{new int[]{1,2,3}, new int[]{4}, new int[]{5,6}}));
        System.out.println(flattenArrays(new int[][]{new int[]{1,2,3}, new int[]{4}, new int[]{5,6}}));
    }
}
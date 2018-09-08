import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static List<Integer> longestIncreasingSubsequence(int[] arr) {
        return longestIncreasingSubsequence(arr, 0, 0);
    }
    
    private static List<Integer> longestIncreasingSubsequence(int[] arr, int i, int min) {
        if (i == arr.length) {
            return new LinkedList<Integer>();
        }
        
        List<Integer> maxList = longestIncreasingSubsequence(arr, i+1, min);
        
        if (arr[i] > min) {
            List<Integer> includeI = longestIncreasingSubsequence(arr, i+1, arr[i]);
            includeI.add(0, arr[i]);
            if (includeI.size() > maxList.size()) maxList = includeI;
        }
        
        return maxList;
    }
    
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{9,6,1,5,10,13,55,12}));
        System.out.println(longestIncreasingSubsequence(new int[]{9,8,7,6,5,4,3,2,1}));
    }
}
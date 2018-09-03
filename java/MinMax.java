import java.util.Arrays;

public class MinMax {
    public static int[] minMax(int[] arr) {
        int[] result = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        minMax(arr, 0, result);
        return result;
    }
    
    private static void minMax(int[] arr, int i, int[] result) {
        if (i >= arr.length) return;
        result[0] = Math.min(result[0], arr[i]);
        result[1] = Math.max(result[1], arr[i]);
        minMax(arr, i+1, result);
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minMax(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(minMax(new int[]{5,4,3,2,1})));
    }
}
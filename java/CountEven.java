/*
 * Title: Count Even
 * Author: Sam Gavis-Hughson
 * Date: 2/15/19
 * 
 * Given an array, count the number of even values in the array
 * 
 * eg. 
 * countEven({1, 2, 3, 4, 5}) = 2
 * 
 * Execution: javac CountEven.java && java CountEven
 */

public class CountEven {
    
    // Global variable for saving the result
    static int globalResult;
    
    // Count even values using a global variable
    public static void countEvenGlobal(int[] arr) {
        globalResult = 0;
        countEvenGlobal(arr, 0);
    }
    
    // Recursive inner function
    private static void countEvenGlobal(int[] arr, int i) {
        // If we reach the end of the array, we're done
        if (i >= arr.length) return;
        
        // If the current value is even, increment the result
        if (arr[i] % 2 == 0) globalResult++;
        countEvenGlobal(arr, i+1);
    }
    
    // Wrapper class so that we can pass-by-reference
    public static class ResultWrapper {
        int result;
    }
    
    // Count even values using a passed variable
    public static int countEvenPassed(int[] arr) {
        ResultWrapper result = new ResultWrapper();
        result.result = 0;
        countEvenPassed(arr, 0, result);
        return result.result;
    }
    
    // Recursive inner class
    private static void countEvenPassed(int[] arr, int i, ResultWrapper result) {
        // If we reach the end of the array, return
        if (i >= arr.length) return;
        
        // If the value is even, update the result
        if (arr[i] % 2 == 0) result.result++;
        countEvenPassed(arr, i+1, result);
    }
    
    // Count even values by building up as we return
    public static int countEvenBuiltUp(int[] arr) {
        return countEvenBuiltUp(arr, 0);
    }
    
    // Recursive inner class
    private static int countEvenBuiltUp(int[] arr, int i) {
        // If we reach the end, return 0
        if (i >= arr.length) return 0;
        
        // Otherwise make our recursive call and then add 1 to the value if the
        // current value is even
        int result = countEvenBuiltUp(arr, i+1);
        if (arr[i] % 2 == 0) result++;
        
        return result;
    }
    
    public static void main(String[] args) {
        countEvenGlobal(new int[]{1,2,3,4,5,6,7});
        System.out.println(globalResult);
        System.out.println(countEvenPassed(new int[]{1,2,3,4,5,6,7}));
        System.out.println(countEvenBuiltUp(new int[]{1,2,3,4,5,6,7}));
    }
}
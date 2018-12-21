public class CountEven {
    static int globalResult;
    public static void countEvenGlobal(int[] arr) {
        globalResult = 0;
        countEvenGlobal(arr, 0);
    }
    
    private static void countEvenGlobal(int[] arr, int i) {
        if (i >= arr.length) return;
        if (arr[i] % 2 == 0) globalResult++;
        countEvenGlobal(arr, i+1);
    }
    
    public static class ResultWrapper {
        int result;
    }
    
    public static int countEvenPassed(int[] arr) {
        ResultWrapper result = new ResultWrapper();
        result.result = 0;
        countEvenPassed(arr, 0, result);
        return result.result;
    }
    
    private static void countEvenPassed(int[] arr, int i, ResultWrapper result) {
        if (i >= arr.length) return;
        if (arr[i] % 2 == 0) result.result++;
        countEvenPassed(arr, i+1, result);
    }
    
    public static int countEvenBuiltUp(int[] arr) {
        return countEvenBuiltUp(arr, 0);
    }
    
    private static int countEvenBuiltUp(int[] arr, int i) {
        if (i >= arr.length) return 0;
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
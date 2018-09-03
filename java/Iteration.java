public class Iteration {
    
    public static void printForwardIterative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static void printForward(int[] arr) {
        printForward(arr, 0);
    }
    
    private static void printForward(int[] arr, int i) {
        if (i == arr.length) return;
        System.out.println(arr[i]);
        printForward(arr, i+1);
    }
    
    public static void printBackwardIterative(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
    
    public static void printBackward(int[] arr) {
        printBackward(arr, 0);
    }
    
    private static void printBackward(int[] arr, int i) {
        if (i == arr.length) return;
        printBackward(arr, i+1);
        System.out.println(arr[i]);
    }
    
    public static void printOdd(int[] arr) {
        printOdd(arr, 0);
    }
    
    private static void printOdd(int[] arr, int i) {
        if (i == arr.length) return;
        if (i % 2 == 1) System.out.println(arr[i]);
        printOdd(arr, i+1);
    }
    
    public static void printOdd2(int[] arr) {
        printOdd2(arr, 1);
    }
    
    private static void printOdd2(int[] arr, int i) {
        if (i >= arr.length) return;
        System.out.println(arr[i]);
        printOdd2(arr, i+2);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        printForwardIterative(arr);
        printForward(arr);
        
        printBackwardIterative(arr);
        printBackward(arr);
        
        printOdd(arr);
        printOdd2(arr);
    }
}
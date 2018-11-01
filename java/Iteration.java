/*
 * Title: Iteration
 * Author: Sam Gavis-Hughson
 * Date: 11/1/2018
 * 
 * A variety of functions for iterating over an array iteratively and 
 * recursively.
 * 
 * eg. 
 * printForward({1, 2, 3, 4, 5})
 * 1
 * 2
 * 3
 * 4
 * 5
 * 
 * Execution: javac Iteration.java && java Iteration
 */

public class Iteration {
    
    // Iteratively print an array from start to end
    public static void printForwardIterative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    // Recursively print an array from start to end
    public static void printForwardRecursive(int[] arr) {
        printForwardRecursive(arr, 0);
    }
    
    // Recursive inner function
    private static void printForwardRecursive(int[] arr, int i) {
        // Once we reach the end of the array, we've printed everything
        if (i == arr.length) return;
        
        // If we haven't reached the end, print the current item and then 
        // increment the counter
        System.out.println(arr[i]);
        printForwardRecursive(arr, i+1);
    }
    
    // Iteratively print an array from end to start
    public static void printBackwardIterative(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
    
    // Recursively print an array from end to start
    public static void printBackwardRecursive(int[] arr) {
        printBackwardRecursive(arr, 0);
    }
    
    // Recursive inner function
    private static void printBackwardRecursive(int[] arr, int i) {
        // Once we reach the end of the array, return and start printing
        if (i == arr.length) return;
        
        // If we haven't reached the end, recursively print the remaining items,
        // then print the current item
        printBackwardRecursive(arr, i+1);
        System.out.println(arr[i]);
    }
    
    // Recursively print all odd indices in an array
    public static void printOddRecursive(int[] arr) {
        printOddRecursive(arr, 0);
    }
    
    // Recursive inner function
    private static void printOddRecursive(int[] arr, int i) {
        if (i == arr.length) return;
        
        // Only print the item if it's odd
        if (i % 2 == 1) System.out.println(arr[i]);
        printOddRecursive(arr, i+1);
    }
    
    // Recursively print all odd elements in an array, optimal method
    public static void printOddRecursive2(int[] arr) {
        printOddRecursive2(arr, 1);
    }
    
    // Recursive inner function
    private static void printOddRecursive2(int[] arr, int i) {
        if (i >= arr.length) return;
        System.out.println(arr[i]);
        printOddRecursive2(arr, i+2);
    }
    
    // Test main method
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        printForwardIterative(arr);
        printForwardRecursive(arr);
        
        printBackwardIterative(arr);
        printBackwardRecursive(arr);
        
        printOddRecursive(arr);
        printOddRecursive2(arr);
    }
}
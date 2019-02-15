/*
 * Title: Combinations
 * Author: Sam Gavis-Hughson
 * Date: 2/15/19
 * 
 * Given an array, write a function to find all combinations (powerset) of 
 * the elements in the array
 * 
 * eg. 
 * combinations({1, 2, 3}) = [[1], [1,2], [1,3], [1,2,3], [2], [2,3], [3], []]
 * 
 * Execution: javac Combinations.java && java Combinations
 */

import java.util.List;
import java.util.LinkedList;

public class Combinations {
    
    // Global variable to store result
    static List<List<Integer>> results;
    
    // Compute all combinations using a global variable
    public static void combinationsGlobal(int[] n) {
        results = new LinkedList<List<Integer>>();
        combinationsGlobal(n, 0, new LinkedList<Integer>());
    }
    
    // Recursive inner function
    private static void combinationsGlobal(int[] n, int i,  List<Integer> path) {
        // If we reach the end of the array, add the current path to the result
        if (i == n.length) {
            results.add(path);
            return;
        }
        
        // Make one copy of the path that includes the current item
        List<Integer> pathWithCurrent = new LinkedList(path);
        pathWithCurrent.add(n[i]);
        
        // Find all the combinations that exclude current item
        combinationsGlobal(n, i+1, path);
        
        // Find all the combinations that include current item
        combinationsGlobal(n, i+1, pathWithCurrent);
    }
    
    // Find all combinations using a passed variable
    public static List<List<Integer>> combinationsPassed(int[] n) {
        // Initialize the result list and pass to our recursive function
        List<List<Integer>> results = new LinkedList();
        combinationsPassed(n, 0, results, new LinkedList<Integer>());
        
        return results;
    }
    
    // Recursive inner function
    private static void combinationsPassed(int[] n, int i, List<List<Integer>> results, 
                                           List<Integer> path) {
        // If we reach the end of the array, add the current path to the result
        if (i == n.length) {
            results.add(path);
            return;
        }
        
        // Make one copy of the path that includes the current item
        List<Integer> pathWithCurrent = new LinkedList(path);
        pathWithCurrent.add(n[i]);
        
        // Find all the combinations that exclude current item
        combinationsPassed(n, i+1, results, path);
        
        // Find all the combinations that include current item
        combinationsPassed(n, i+1, results, pathWithCurrent);
    }
    
    // Find all combinations by building up the results
    public static List<List<Integer>> combinationsBuiltUp(int[] n) {
        return combinationsBuiltUp(n, 0);
    }
    
    // Recursive inner function
    private static List<List<Integer>> combinationsBuiltUp(int[] n, int i) {
        // When we reach the end of our array, we have a single result
        // -- An empty list
        if (i == n.length) {
            List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
            toReturn.add(new LinkedList<Integer>());
            
            // Return [[]]
            return toReturn;
        }
        
        // Create a new list to save the new result
        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
        
        // Get all combinations from i+1 to the end of the list. Then for each
        // of those, both include and exclude the current item
        for (List<Integer> result : combinationsBuiltUp(n, i+1)) {
            // Exclude current item
            toReturn.add(new LinkedList<Integer>(result));
            
            // Include current item
            result.add(0, n[i]);
            toReturn.add(new LinkedList<Integer>(result));
        }
        
        return toReturn;
    }
    
    // Count the number of unique combinations of an array
    public static int countCombinations(int[] n) {
        return countCombinations(n, 0);
    }
    
    // Recursive inner function
    private static int countCombinations(int[] n, int i) {
        // When we hit our ase case we've found one valid combination
        if (i == n.length) {
            return 1;
        }
        
        // Otherwise try including and excluding the current item
        int include = countCombinations(n, i+1);
        int exclude = countCombinations(n, i+1);
        
        return include + exclude;
    }
    
    public static void main(String[] args) {
        combinationsGlobal(new int[]{1,2,3});
        System.out.println(results);
        System.out.println(combinationsPassed(new int[]{1,2,3,4}));
        System.out.println(combinationsPassed(new int[]{1,2,3,4,5}));
        System.out.println(countCombinations(new int[]{1,2,3}));
    }
}
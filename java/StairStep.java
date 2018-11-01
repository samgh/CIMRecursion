/*
 * Title: Stair Step
 * Author: Sam Gavis-Hughson
 * Date: 11/1/2018
 * 
 * Given a height of a staircase, n, determine the number of ways you can reach
 * the top by taking steps of size 1, 2, or 3.
 * 
 * Execution: javac StairStep.java && java StairStep
 */

import java.util.LinkedList;
import java.util.List;

public class StairStep {
    
    // Count the number of ways up the staircase
    public static int stairStepCount(int n) {
        // If n==0, we're at the top, so there's one way. If n<0, we've passed
        // the top, so there are no valid paths
        if (n == 0) return 1;
        if (n < 0) return 0;
        
        // Find all the ways if you took 1, 2, or 3 steps from the current position
        return stairStepCount(n-1) + stairStepCount(n-2) + stairStepCount(n-3);
    }
    
    // Find a list of all of the paths up the staircase
    public static List<List<Integer>> stairStep(int n) {
        // We have one valid path, which is to take no steps from where we are
        if (n == 0) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        
        // We have no valid paths
        if (n < 0) {
            return new LinkedList<List<Integer>>();
        }
        
        // Try taking 1, 2, or 3 steps from where we are and find all those paths
        List<List<Integer>> result = 
            new LinkedList<List<Integer>>(stairStep(n-1));
        result.addAll(stairStep(n-2));
        result.addAll(stairStep(n-3));
        
        // Since we stepped from our current step, include the current step in 
        // the path.
        for (List<Integer> l : result) {
            l.add(n);
        }
        
        return result;
    }
    
    // Similar implementation that counts up rather than counting down
    public static List<List<Integer>> stairStep2(int n) {
        return stairStep2(n, 0);
    }
    
    // Inner recursive function
    private static List<List<Integer>> stairStep2(int n, int currentStep) {
        if (currentStep == n) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            result.add(new LinkedList<Integer>());
            return result;
        }
        if (currentStep > n) {
            return new LinkedList<List<Integer>>();
        }
        
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        result.addAll(stairStep2(n, currentStep+1));
        result.addAll(stairStep2(n, currentStep+2));
        result.addAll(stairStep2(n, currentStep+3));
        
        // We are generating the list from step X to the top of the staircase,
        // so we insert the current step at the beginning of the list
        for (List<Integer> l : result) {
            l.add(0, currentStep);
        }
        
        return result;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        System.out.println(stairStep2(3));
        System.out.println(stairStep2(4));
        System.out.println(stairStep2(5));
    }
}
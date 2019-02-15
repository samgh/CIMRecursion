/*
 * Title: Unique BSTs
 * Author: Sam Gavis-Hughson
 * Date: 2/15/19
 * 
 * Given a number of items, determine the number of different unique BSTs you
 * can generate using that set of inputs
 * 
 * eg. 
 * countBSTs(4) = 14
 * 
 * Execution: javac UniqueBSTs.java && java UniqueBSTs
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueBSTs {
    
    // Count the number of unique BSTs
    public static int countBSTs(int n) {
        // If a tree has 0 or 1 node, there's exactly 1 unique tree we can make
        if (n <= 1) return 1;
        int count = 0;
        
        // Try selecting each possible root and then finding the number of 
        // combinatinos on the left side and on the right side
        for (int i = 0; i < n; i++) {
            count += countBSTs(i) * countBSTs(n-i-1);
        }
        
        return count;
    }
    
    // Find all unique BSTs
    public static List<List<Integer>> uniqueBSTs(int n) {
        return uniqueBSTs(0, n);
    }
    
    // Recursive inner function
    private static List<List<Integer>> uniqueBSTs(int min, int max) {
        // If min and max are equal, subtree has a single node
        if (min == max) {
            List<List<Integer>> temp = new LinkedList<List<Integer>>();
            temp.add(Arrays.asList(min));
            return temp;
        }
        
        // Try each possible root node
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = min; i < max; i++) {
            // Get the order for the left subtree and the order for the right
            List<List<Integer>> left = uniqueBSTs(min, i);
            List<List<Integer>> right = uniqueBSTs(i+1, max);
            
            // Merge every combination of left subtree and right subtree
            for (List<Integer> l1 : left) {
                for (List<Integer> l2 : right) {
                    List<Integer> temp = new LinkedList<Integer>();
                    temp.add(i);
                    temp.addAll(l1);
                    temp.addAll(l2);
                    result.add(temp);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(countBSTs(3));
        System.out.println(countBSTs(4));
    }
}
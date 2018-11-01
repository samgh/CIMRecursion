/*
 * Title: InsertAtBottom
 * Author: Sam Gavis-Hughson
 * Date: 11/1/2018
 * 
 * Given a stack, write a function to insert an item at the bottom of the stack.
 * 
 * insertAtBottom({1,2,3}, 4) = {1,2,3,4}
 * 
 * Execution: javac InsertAtBottom.java && java InsertAtBottom
 */

import java.util.Stack;

public class InsertAtBottom {
    
    // Iteratively insert item at bottom of stack using an auxilary stack
    public static void insertAtBottomIterative(Stack<Integer> s, int i) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!s.isEmpty()) temp.push(s.pop());
        s.push(i);
        while (!temp.isEmpty()) s.push(temp.pop());
    }
    
    // Recursively insert item at bottom of stack. Recursively iterate to the
    // bottom of the stack, then insert i and return, replacing items above
    public static void insertAtBottomRecursive(Stack<Integer> s, int i) {
        
        // When we've removed everything from the stack, insert i
        if (s.isEmpty()) {
            s.push(i);
            return;
        }
        
        // Save the current value in the stack frame. Then recurse to the bottom
        // of the stack and insert i
        int top = s.pop();
        insertAtBottomRecursive(s, i);
        s.push(top);
    }
    
    // Sample test case
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        insertAtBottomRecursive(s, 5);
        System.out.println(s);
    }
}
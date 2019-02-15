/*
 * Title: Print Reversed Linked List
 * Author: Sam Gavis-Hughson
 * Date: 2/15/19
 * 
 * Given a linked list, write a function to print the values of the linked list
 * in reverse order
 * 
 * eg. 
 * printReverseLinkedList(1 -> 2 -> 3 -> 4 -> null)
 * 4
 * 3
 * 2
 * 1
 * 
 * Execution: javac PrintReversedLinkedList.java && java PrintReversedLinkedList
 */

import java.util.Stack;

public class PrintReversedLinkedList {
    public static class Node {
        int val;
        Node next;
        
        public Node(int n) {
            this.val = n;
        }
    }
    
    // Recursively print linked list in reverse order
    public static void printReversedLinkedList(Node head) {
        // If we reach the end of the list, return
        if (head == null) return;
        
        // Otherwise first recurse to the end and then print as we return
        printReversedLinkedList(head.next);
        System.out.println(head.val);
    }
    
    // Iteratively print linked list in reverse using a stack
    public static void printReversedLinkedListIterative(Node head) {
        // Add all the items to a LIFO stack
        Stack<Node> s = new Stack<Node>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }
        
        // Pop everything from the stack and print
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    
    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
            
        printReversedLinkedList(list);
    }
}
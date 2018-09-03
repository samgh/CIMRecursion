public class FilterList {

    public static class Node {
        Node next;
        int val;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    public static Node lessThanIterative(Node head, int cutoff) {
        Node newHead = head;
        while (newHead != null && newHead.val >= cutoff) {
            newHead = newHead.next;
        }
        
        Node curr = newHead;
        while (curr != null && curr.next != null) {
            if (curr.next.val >= cutoff) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        return newHead;
    }
    
    public static Node lessThan(Node head, int cutoff) {
        if (head == null) {
            return null;
        }
        
        Node remainder = lessThan(head.next, cutoff);
        
        if (head.val < cutoff) {
            head.next = remainder;
            return head;
        }
        return remainder;
    }
    
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(1);
        head.next.next = new Node(10);
        head.next.next.next = new Node(7);
        
        printList(lessThanIterative(head, 11));
    }
    
    private static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
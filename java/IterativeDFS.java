import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class IterativeDFS {
    public static class Node {
        int value;
        Node left;
        Node right;
        
        public Node(int value) {
            this.value = value;
        }
        
        public String toString() {
            return "" + value;
        }
    }
    
    public static void iterativeDFS(Node root) {
        Stack<Node> items = new Stack<Node>();
        Set<Node> visited = new HashSet<Node>();
        items.push(root);
        
        while (!items.isEmpty()) {
            Node top = items.peek();
            boolean unvisitedChildren = false;
            if (top.right != null && !visited.contains(top.right)) {
                items.push(top.right);
                unvisitedChildren = true;
            }
            if (top.left != null && !visited.contains(top.left)) {
                items.push(top.left);
                unvisitedChildren = true;
            }
            
            if (!unvisitedChildren) {
                visited.add(top);
                items.pop();
                System.out.println(top);
            }
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        iterativeDFS(root);
    }
}
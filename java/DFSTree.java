import java.util.LinkedList;
import java.util.List;

public class DFSTree {
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
    
    public static boolean contains(Node root, int val) {
        if (root == null) return false;
        if (root.value == val) return true;
        return contains(root.left, val) || contains(root.right, val);
    }
    
    public static List<Node> pathToNode(Node root, int val) {
        if (root == null) return null;
        if (root.value == val) {
            List<Node> toReturn = new LinkedList<Node>();
            toReturn.add(root);
            return toReturn;
        }
        
        List<Node> left = pathToNode(root.left, val);
        if (left != null) {
            left.add(0, root);
            return left;
        }
        
        List<Node> right = pathToNode(root.right, val);
        if (right != null) {
            right.add(0, root);
            return right;
        }
        return null;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        System.out.println(pathToNode(root, 0));
    }
}
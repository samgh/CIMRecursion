import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class TreeDiameter {
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
    
    public static int diameterBruteForce(Node root) {
        if (root == null) return 0;
        
        int currentDiameter = 1 + height(root.left) + height(root.right);
        
        return Math.max(currentDiameter, Math.max(diameterBruteForce(root.left),
                                                  diameterBruteForce(root.right)));
    }
    
    private static int height(Node root) {
        if (root == null) return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public static int diameterOptimized(Node root) {
        Map<Node, Integer> allHeights = new HashMap<Node, Integer>();
        allHeights(root, allHeights);
        return diameterOptimized(root, allHeights);
    }
    
    private static int diameterOptimized(Node root, Map<Node, Integer> heights) {
        if (root == null) return 0;
        
        int leftHeight = root.left == null ? 0 : heights.get(root.left);
        int rightHeight = root.right == null ? 0 : heights.get(root.right);
        
        return Math.max(1 + leftHeight + rightHeight,
                        Math.max(diameterOptimized(root.left, heights),
                                 diameterOptimized(root.right, heights)));
    }
    
    private static int allHeights(Node root, Map<Node, Integer> heights) {
        if (root == null) return 0;
        int height = 1+ Math.max(allHeights(root.left, heights), allHeights(root.right, heights));
        heights.put(root, height);
        return height;
    }
    
    public static class Height {
        int height;
        
        public Height() {
            this.height = 0;
        }
    }
    
    public static int diameterSpaceOptimized(Node root) {
        return diameterSpaceOptimized(root, new Height());
    }
    
    private static int diameterSpaceOptimized(Node root, Height h) {
        if (root == null) return 0;
        
        Height heightLeft = new Height();
        Height heightRight = new Height();
        
        int diamLeft = diameterSpaceOptimized(root.left, heightLeft);
        int diamRight = diameterSpaceOptimized(root.right, heightRight);
        
        h.height = 1 + Math.max(heightLeft.height, heightRight.height);
        return Math.max(1 + heightLeft.height + heightRight.height,
                        Math.max(diamLeft, diamRight));
    }
    
    public static class Path {
        List<Node> path;
        
        public Path() {
            this.path = new LinkedList<Node>();
        }
    }
    
    public static List<Node> diameterList(Node root) {
        return diameterList(root, new Path());
    }
    
    private static List<Node> diameterList(Node root, Path path) {
        if (root == null) return new LinkedList<Node>();
        
        Path leftPath = new Path();
        Path rightPath = new Path();
        
        List<Node> diamLeft = diameterList(root.left, leftPath);
        List<Node> diamRight = diameterList(root.right, rightPath);
        
        List<Node> result = diamLeft;
        if (diamRight.size() > result.size()) result = diamRight;
        if (leftPath.path.size() + rightPath.path.size() + 1 > result.size()) {
            result = new LinkedList<Node>();
            result.addAll(leftPath.path);
            Collections.reverse(result);
            result.add(root);
            result.addAll(rightPath.path);
        }
        
        if (leftPath.path.size() > rightPath.path.size()) path.path = leftPath.path;
        else path.path = rightPath.path;
        
        path.path.add(0, root);
        
        return result;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.left.right.left = new Node(8);
        System.out.println(diameterList(root));
    }
}
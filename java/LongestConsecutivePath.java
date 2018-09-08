public class LongestConsecutivePath {
    public static class Node {
        int value;
        Node left;
        Node right;
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    public static int longestConsecutivePath(Node root) {
        return longestConsecutivePath(root, 1, root);
    }
    
    private static int longestConsecutivePath(Node root, int pathLength, Node parent) {
        if (root == null) return pathLength;
        
        if (root.value == parent.value+1) {
            return Math.max(longestConsecutivePath(root.left, pathLength+1, root),
                            longestConsecutivePath(root.right, pathLength+1, root));
        }
        
        return Math.max(pathLength, Math.max(longestConsecutivePath(root.left, 1, root),
                                             longestConsecutivePath(root.right, 1, root)));            
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(5);
        
        System.out.println(longestConsecutivePath(root));
    }
}
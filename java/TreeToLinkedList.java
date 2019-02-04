public class TreeToLinkedList {
    public static class Node {
        int value;
        Node next;
        Node prev;
        
        public Node(int value) {
            this.value = value;
        }
        
        public String toString() {
            return "{" + value + ", prev=" + prev.value + ", next=" + next.value + "}";
        }
    }
    
    public static Node treeToLinkedList(Node root) {
        if (root == null) return null;
        
        Node left = treeToLinkedList(root.prev);
        Node right = treeToLinkedList(root.next);
        
        root.prev = root;
        root.next = root;
        
        if (left != null) root = connectLists(left, root);
        if (right != null) root = connectLists(root, right);
        
        return root;
    }
    
    private static Node connectLists(Node l1, Node l2) {
        Node l1End = l1.prev;
        Node l2End = l2.prev;
        
        l1End.next = l2;
        l2.prev = l1End;
        l2End.next = l1;
        l1.prev = l2End;
        
        return l1;
    }
    
    public static void main(String[] args) {
        Node[] tree = new Node[]{new Node(1), new Node(2), new Node(3), new Node(4), new Node(5)};
        Node root = tree[0];
        root.prev = tree[1];
        root.next = tree[2];
        root.prev.next = tree[3];
        root.next.prev = tree[4];
        
        /*
         *          1
         *       /     \
         *     2        3
         *      \      /
         *       4    5
         * 
         *  - 2 - 4 - 1 - 5 - 3 -
         * 
         */
        
        treeToLinkedList(root);
        for (Node n : tree) System.out.println(n);
    }
}
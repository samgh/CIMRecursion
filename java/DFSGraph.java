import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DFSGraph {
    public static class Node {
        int value;
        Node[] neighbors;
        
        public Node(int value) {
            this.value = value;
        }
        
        public String toString() {
            return "" + value;
        }
    }
    
    public static boolean pathExists(Node src, Node dest) {
        return pathExists(src, dest, new HashSet<Node>());
    }
    
    private static boolean pathExists(Node curr, Node dest, Set<Node> visited) {
        if (visited.contains(curr)) return false;
        if (curr == dest) return true;
        
        visited.add(curr);
        for (Node n : curr.neighbors) {
            if (pathExists(n, dest, visited)) return true;
        }
        return false;
    }
    
    public static List<List<Node>> paths(Node src, Node dest) {
        List<List<Node>> results = new LinkedList<List<Node>>();
        paths(src, dest, new HashSet<Node>(), new LinkedList<Node>(), results);
        return results;
    }
    
    private static void paths(Node curr, Node dest, Set<Node> visited, List<Node> path, List<List<Node>> results) {
        if (visited.contains(curr)) return;
        if (curr == dest) {
            path.add(curr);
            results.add(new LinkedList<Node>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        visited.add(curr);
        path.add(curr);
        for (Node n : curr.neighbors) {
            paths(n, dest, visited, path, results);
        }
        path.remove(path.size() - 1);
        visited.remove(curr);
    }
    
    public static void main(String[] args) {
        Node[] graph = new Node[6];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Node(i);
        }
        
        graph[0].neighbors = new Node[]{graph[1], graph[2], graph[3]};
        graph[1].neighbors = new Node[]{graph[4], graph[1]};
        graph[2].neighbors = new Node[]{graph[2]};
        graph[3].neighbors = new Node[]{graph[1]};
        graph[4].neighbors = new Node[]{graph[1], graph[2], graph[3]};
        graph[5].neighbors = new Node[]{};
        
        System.out.println(paths(graph[0], graph[4]));
    }
}
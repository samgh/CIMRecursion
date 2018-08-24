import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TowersOfHanoi {
    public static int moveCount(int n) {
        if (n == 1) return 1;
        return 2 * moveCount(n-1) + 1;
    }
    
    public static class Move {
        int disk;
        int src;
        int dest;
        
        public Move(int disk, int src, int dest) {
            this.disk = disk;
            this.src = src;
            this.dest = dest;
        }
        
        public String toString() {
            return "" + disk + " from " + src + " to " + dest;
        }
    }
    
    public static List<Move> moves(int n) {
        return moves(n, 0, 2, 1);
    }

    private static List<Move> moves(int n, int src, int dest, int aux) {
        if (n == 1) return Arrays.asList(new Move(n, src, dest));
        List<Move> result = new LinkedList<Move>();
        result.addAll(moves(n-1, src, aux, dest));
        result.add(new Move(n, src, dest));
        result.addAll(moves(n-1, aux, dest, src));
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(moves(10));
    }
}
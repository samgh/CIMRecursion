import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TowersOfHanoi {
    public enum Position {
        SRC {
            public String toString() { return "SRC"; }
        }, 
        DEST {
            public String toString() { return "DEST"; }
        },
        AUX {
            public String toString() { return "AUX"; }
        };
    }
    
    public static int moveCount(int n) {
        if (n == 1) return 1;
        return 2 * moveCount(n-1) + 1;
    }
    
    public static class Move {
        int disk;
        Position src;
        Position dest;
        
        public Move(int disk, Position src, Position dest) {
            this.disk = disk;
            this.src = src;
            this.dest = dest;
        }
        
        public String toString() {
            return "" + disk + " from " + src + " to " + dest;
        }
    }
    
    public static List<Move> moves(int n) {
        return moves(n, Position.SRC, Position.DEST, Position.AUX);
    }

    private static List<Move> moves(int n, Position src, Position dest, Position aux) {
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
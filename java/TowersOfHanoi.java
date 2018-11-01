/*
 * Title: Towers of Hanoi
 * Author: Sam Gavis-Hughson
 * Date: 11/1/2018
 * 
 * Given a number of disks, write a function to find the set of moves needed to
 * solve the Towers of Hanoi puzzle 
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi
 * 
 * Execution: javac TowersOfHanoi.java && java TowersOfHanoi
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TowersOfHanoi {
    
    // Enum for each of the 3 positions that a disk can be in. This enum also
    // contains toString() methods to make printing easier
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
    
    // Recursively count the number of moves to move n disks. If there is 1
    // disk, it takes 1 move. Otherwise, move n-1 disks to AUX, then bottom disk
    // to DEST, then n-1 disks from AUX to DEST
    public static int moveCount(int n) {
        // 0 or negative disks take 0 moves, one disk only takes one move
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        // Count the number of moves to move n-1 disks to AUX and then to DEST
        return 2 * moveCount(n-1) + 1;
    }
    
    // Simple move class to simplify code
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
    
    // Recursively compute the list of moves required to move n disks
    public static List<Move> moves(int n) {
        return moves(n, Position.SRC, Position.DEST, Position.AUX);
    }

    // Recursive inner function
    private static List<Move> moves(int n, Position src, Position dest, Position aux) {
        // If we have 0 or negative disks, no moves. If we have one disk, just
        // move it directly to DEST
        if (n <= 0) return new LinkedList<Move>();
        if (n == 1) return Arrays.asList(new Move(n, src, dest));
        
        // Move the n-1 disks to AUX, then the n disk to DEST, then n-1 from 
        // AUX to DEST. We simply append the moves required to do each.
        List<Move> result = new LinkedList<Move>();
        result.addAll(moves(n-1, src, aux, dest));
        result.add(new Move(n, src, dest));
        result.addAll(moves(n-1, aux, dest, src));
        return result;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        System.out.println(moveCount(5));
        System.out.println(moves(5));
    }
}
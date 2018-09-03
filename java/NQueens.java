import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NQueens {
    public static class Cell {
        int row;
        int col;
        
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public String toString() {
            return "{r: " + row + ", c: " + col + "}";
        }
    }
    
    public static List<List<Cell>> nQueensBruteForce(int dim, int N) {
        List<List<Cell>> results = new LinkedList<List<Cell>>();
        nQueensBruteForce(dim, N, 0, 0, new LinkedList<Cell>(), results);
        return results;
    }
    
    private static void nQueensBruteForce(int dim, int N, int row, int col, 
                         List<Cell> path, List<List<Cell>> results) {
        if (path.size() == N) {
            results.add(new LinkedList<Cell>(path));
            return;
        }
        if (row == dim || col == dim) return;
        
        path.add(new Cell(row, col));
        nQueensBruteForce(dim, N, row, col+1, path, results);
        nQueensBruteForce(dim, N, row+1, 0, path, results);
        
        path.remove(path.size() - 1);
        nQueensBruteForce(dim, N, row, col+1, path, results);
        nQueensBruteForce(dim, N, row+1, 0, path, results);
    }
    
    public static List<List<Cell>> nQueensOptimized(int dim, int N) {
        List<List<Cell>> results = new LinkedList<List<Cell>>();
        Set<Integer> availableCols = new HashSet<Integer>();
        for (int i = 0; i < dim; i++) availableCols.add(i);
        nQueensOptimized(dim, N, 0, availableCols, new HashSet<Integer>(), 
                         new HashSet<Integer>(), new LinkedList<Cell>(), results);
        return results;
    }
    
    private static void nQueensOptimized(int dim, int N, int row, Set<Integer> availableCols,
                                         Set<Integer> leftDiagonals, Set<Integer> rightDiagonals,
                                         List<Cell> path, List<List<Cell>> results) {
        if (path.size() == N) {
            results.add(new LinkedList<Cell>(path));
            return;
        }
        
        if (row >= dim) return;
        
        for (Integer col : availableCols.toArray(new Integer[]{})) {
            if (leftDiagonals.contains(row - col) || rightDiagonals.contains(row + col)) continue;
            path.add(new Cell(row, col));
            availableCols.remove(col);
            leftDiagonals.add(row - col);
            rightDiagonals.add(row + col);
            
            nQueensOptimized(dim, N, row+1, availableCols, leftDiagonals, rightDiagonals, path, results);
            
            path.remove(path.size() - 1);
            availableCols.add(col);
            leftDiagonals.remove(row - col);
            rightDiagonals.remove(row + col);
        }
        
        nQueensOptimized(dim, N, row+1, availableCols, leftDiagonals, rightDiagonals, path, results);
    }
    
    public static void main(String[] args) {
        System.out.println(nQueensOptimized(8 ,8));
    }
}
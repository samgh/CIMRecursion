import java.util.LinkedList;
import java.util.List;

public class GreatestProductPath {
    public static class Coordinate {
        int x;
        int y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    
    public static int greatestProductPath(int[][] matrix) {
        return greatestProductPath(matrix, 0, 0);
    }
    
    private static int greatestProductPath(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) return matrix[i][j];
        if (i >= matrix.length || j >= matrix[0].length) return 0;
        
        return matrix[i][j] * Math.max(greatestProductPath(matrix, i+1, j),
                                       greatestProductPath(matrix, i, j+1));
    }
    
    public static int greatestProductPath2(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        result.add(Integer.MIN_VALUE);
        greatestProductPath2(matrix, 0, 0, 1, result);
        return result.get(0);
    }
    
    private static void greatestProductPath2(int[][] matrix, int i, int j, int product, List<Integer> result) {
        if (i >= matrix.length || j >= matrix[0].length) return;
        
        product *= matrix[i][j];
        
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            if (result.get(0) < product) {
                result.set(0, product);
            }
            return;
        }
        
        greatestProductPath2(matrix, i+1, j, product, result);
        greatestProductPath2(matrix, i, j+1, product, result);
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            new int[]{1,2,3},
            new int[]{4,5,6},
            new int[]{-7,8,9}};
        
        System.out.println(greatestProductPath2(matrix));
    }
}
public class SquareSubmatrix {
    // Brute force solution
    public static int squareSubmatrix(boolean[][] arr) {
        int max = 0;
        // Compute recursively for each cell what it is the upper left corner of        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, squareSubmatrix(arr, i, j));
            }
        }
        
        return max;
    }
    
    // Overloaded recursive function
    private static int squareSubmatrix(boolean[][] arr, int i, int j) {
        // If we get to the bottom or right of the matrix, we can't go any 
        // further
        if (i == arr.length || j == arr[0].length) return 0;
        
        // If the cell is False then it is not part of a valid submatrix
        if (!arr[i][j]) return 0;
        
        // Find the size of the right, bottom, and bottom right submatrices and
        // add 1 to the minimum of those 3 to get the result
        return 1 + Math.min(Math.min(squareSubmatrix(arr, i+1, j), 
                                     squareSubmatrix(arr, i, j+1)),
                            squareSubmatrix(arr, i+1, j+1));
    }
    
    public static void main(String[] args) {
        System.out.println(squareSubmatrix(new boolean[][]{
            new boolean[]{true, true, true, false},
            new boolean[]{false, true, true, true},
            new boolean[]{true, true, true, true}}));
    }
}
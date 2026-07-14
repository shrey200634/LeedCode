


    import java.util.Arrays;

public class dp {

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;
        
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, findMinPath(0, col, matrix, memo));
        }
        
        return minSum;
    }
    
    private int findMinPath(int row, int col, int[][] matrix, int[][] memo) {
        int n = matrix.length;
        
        if (col < 0 || col >= n) {
            return 100000000;
        }
        
        if (row == n - 1) {
            return matrix[row][col];
        }
        
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        
        int downLeft = findMinPath(row + 1, col - 1, matrix, memo);
        int straightDown = findMinPath(row + 1, col, matrix, memo);
        int downRight = findMinPath(row + 1, col + 1, matrix, memo);
        
        memo[row][col] = matrix[row][col] + Math.min(straightDown, Math.min(downLeft, downRight));
        
        return memo[row][col];
    }
}
    
}

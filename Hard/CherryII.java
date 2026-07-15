package Hard;
    import java.util.Arrays;


public class CherryII {




    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // 3D memoization table: dp[rows][cols][cols]
        int[][][] dp = new int[rows][cols][cols];
        
        // Initialize the memo array with -1 to signify unvisited states
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        
        // Start recursion from row 0, Alice at col 0, Bob at the last col
        return maxChocolates(0, 0, cols - 1, grid, dp);
    }
    
    private int maxChocolates(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // 1. Base Case: If out of grid boundaries
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) {
            return (int) -1e9; // Return a large negative value to ignore this path
        }
        
        // 2. Base Case: Reached the last row
        if (i == rows - 1) {
            if (j1 == j2) {
                return grid[i][j1]; // If they land on the same cell, only one picks it up
            } else {
                return grid[i][j1] + grid[i][j2]; // Otherwise, sum both cells
            }
        }
        
        // 3. Return memoized result if already calculated
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        
        // 4. Calculate current row's collection
        int currentChocolates = 0;
        if (j1 == j2) {
            currentChocolates = grid[i][j1];
        } else {
            currentChocolates = grid[i][j1] + grid[i][j2];
        }
        
        // 5. Explore all 9 possible combinations for the next row
        // Alice can move to: j1-1, j1, j1+1
        // Bob can move to: j2-1, j2, j2+1
        int maxFutureChocolates = (int) -1e9;
        
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int nextChocolates = maxChocolates(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                maxFutureChocolates = Math.max(maxFutureChocolates, nextChocolates);
            }
        }
        
        // 6. Memoize and return the result
        return dp[i][j1][j2] = currentChocolates + maxFutureChocolates;
    }
}
    


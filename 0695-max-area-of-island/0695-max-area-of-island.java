import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, r, c));
                }
            }
        }
        
        return maxArea;
    }
    
    private int bfs(int[][] grid, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        int area = 0;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startRow * cols + startCol);
        grid[startRow][startCol] = 0; 
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int currRow = curr / cols;
            int currCol = curr % cols;
            area++;
            
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                    queue.offer(nextRow * cols + nextCol);
                    grid[nextRow][nextCol] = 0;
                }
            }
        }
        
        return area;
    }
}
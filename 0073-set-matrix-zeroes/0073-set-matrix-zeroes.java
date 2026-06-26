import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int j = 0; j < cols; j++) {
                matrix[r][j] = 0;
            }
            
            for (int i = 0; i < rows; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
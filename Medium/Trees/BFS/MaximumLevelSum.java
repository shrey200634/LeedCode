package Medium.Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {  
      }
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    
}

    
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxSum = Integer.MIN_VALUE; 
        int maxLevel = 1;
        int currentLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentLevelSum = 0; 
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                maxLevel = currentLevel;
            }
            
            currentLevel++;
        }

        return maxLevel;
    }
}
    


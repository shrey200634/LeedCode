package Medium.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzagLevelOrder {
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

   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Use LinkedList because adding to the front (0 index) is O(1)
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                // Standard BFS: Always poll from the front
                TreeNode currentNode = queue.poll();

                // ZIGZAG LOGIC:
                if (reverse) {
                    // If reversing, add new values to the START of the list
                    // e.g., 15 -> [15], 7 -> [7, 15]
                    currentLevel.addFirst(currentNode.val);
                } else {
                    // Normal order, add to the END
                    // e.g., 3 -> [3]
                    currentLevel.add(currentNode.val);
                }

                // Standard BFS: Always add children Left then Right
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
            // Toggle the direction for the next level
            reverse = !reverse;
        }

        return result;
    }
}
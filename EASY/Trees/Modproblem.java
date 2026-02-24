package EASY.Trees;

import java.util.ArrayList;
import java.util.List;

public class Modproblem {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  class Solution {
    private Integer prev = null;
    private int count = 1;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        traverse(root);
        
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);

        if (prev != null) {
            if (node.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        
        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }
        
        prev = node.val;

        traverse(node.right);
    }
}

    
}

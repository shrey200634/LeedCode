package Hard;

public class maxSumBST {

class Solution {
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

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

   
    public int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        
        if (left[0] == 1 && right[0] == 1 && 
            node.val > left[2] && node.val < right[1]) {
            
            int currentSum = node.val + left[3] + right[3];
            
            maxSum = Math.max(maxSum, currentSum);
            
            int myMin = Math.min(node.val, left[1]);
            int myMax = Math.max(node.val, right[2]);
            
            return new int[]{1, myMin, myMax, currentSum};
        }

        return new int[]{0, 0, 0, 0};
    }
}



    
}

package Medium.Trees.BFS;

public class SymNumbers {
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
   public int sumNumbers(TreeNode root) {

      return helper(root , 0);


    }

     private int helper (TreeNode node , int currentNum){
       if (node ==null){
        return 0;
       }
        currentNum = (currentNum *10) + node.val; 

        if (node.left ==null && node .right ==null){
            return currentNum ;
        }
        int leftSum = helper(node.left , currentNum);
        int rightSum =helper(node.right , currentNum );

        return leftSum + rightSum;
    }
    
}

package Medium.Trees;

public class FindLeftBottomNode {
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
 int maxdepth =-1;
        int bottomLeftValue =0;
    public int findBottomLeftValue(TreeNode root) {
        
         helper (root ,0);
         return bottomLeftValue;
    
    }
    private void helper( TreeNode node , int currentDepth){
        if (node ==null){
            return ;
        }
          if (currentDepth > maxdepth) {
            maxdepth = currentDepth;
            bottomLeftValue = node.val;
        }

        helper (node.left , currentDepth +1);
                helper (node.right , currentDepth +1);


    }
    
}

package Medium.Trees;

public class MaxiMumDepth {
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
 public int maxDepth(TreeNode root) {
        if (root ==null){
            return 0;
        }
        int rightDepth =maxDepth(root.right );
        int leftDepth=maxDepth(root.left);

        int dept = Math.max(rightDepth ,leftDepth ) +1;
        return dept;
        
    }
    
    }

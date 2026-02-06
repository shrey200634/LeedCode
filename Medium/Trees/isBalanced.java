package Medium.Trees;

public class isBalanced {
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
    public boolean isBalanced(TreeNode root) {
     return checkIt(root) != -1;

    
        
    }
    private int checkIt(TreeNode root ){
        if (root ==null) {
            return 0;
        }
        int leftHeight = checkIt(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkIt(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    
    }
    
}

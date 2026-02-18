package Medium.Trees.DFS;

public class TreeFromPreOrder {
    public class sumOfLeftLeaves {
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
   int i =0;
    public TreeNode bstFromPreorder(int[] preorder) {

        return helper(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE);
       

        
        
    }

   TreeNode helper(int[] preorder , int lowerBound , int upperBound ){
    if (i== preorder.length){
        return null;
    }
     int currentValue = preorder[i];

     if (currentValue <lowerBound||currentValue>upperBound){
        return null;
     }

     TreeNode node = new TreeNode(currentValue);
     i++;

     node.left = helper(preorder , lowerBound , currentValue);
          node.right = helper(preorder , currentValue , upperBound);


          return node ;


   }

    
}

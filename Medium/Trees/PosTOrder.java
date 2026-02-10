package Medium.Trees;

import java.util.ArrayList;
import java.util.List;

public class PosTOrder {
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
     public List<Integer> postorderTraversal(TreeNode root) {
        List <Integer > result = new ArrayList<>();

        helper (root, result  );
        return result ; 

        
    }
    void helper (TreeNode node , List<Integer > result ){
        if ( node == null){
           return ;
        }
        helper (node .left , result);
        helper(node.right , result);

        result.add(node.val);
    }
    
}

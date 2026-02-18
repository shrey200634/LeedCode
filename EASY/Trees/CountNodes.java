package EASY.Trees;

import java.util.ArrayList;

public class CountNodes {
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
  ArrayList<Integer> list = new ArrayList<>();
          int count =0;


    public int countNodes(TreeNode root) {

        if (root ==null){
            return 0;
        }

        list.add(root.val); 

        countNodes(root.left);
        countNodes(root.right);
         
       

        return list.size() ;
    }

    
}

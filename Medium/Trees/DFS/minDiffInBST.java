package Medium.Trees.DFS;

import java.util.ArrayList;

public class minDiffInBST {
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
    public int minDiffInBST(TreeNode root) {
        ArrayList <Integer > list = new ArrayList<>();
         helper (root , list);


         int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
         return minDiff ;
    }
    void  helper ( TreeNode node ,ArrayList<Integer> list ){
        if (node ==null){
            return ;
        }
        helper(node.left , list);
        list.add(node.val);
        helper(node.right, list);
     
    }
    
}

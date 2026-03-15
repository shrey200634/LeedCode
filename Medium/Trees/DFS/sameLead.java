package Medium.Trees.DFS;

import java.util.LinkedList;
import java.util.List;

public class sameLead {
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
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer > one = new LinkedList<>();
        List<Integer> two = new LinkedList<>();

        dfs(root1, one);
        dfs(root2,two);

        return one.equals(two);
        
    }

    void dfs (TreeNode node , List<Integer> leave){
        if (node ==null){
            return ;
        }
        if (node.left ==null && node.right ==null){
            leave.add(node.val);
            return ;
        }
        dfs(node.left , leave );
        dfs(node.right , leave );

    }
    
}

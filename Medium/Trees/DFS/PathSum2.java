package Medium.Trees.DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
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
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List <List<Integer >> result = new ArrayList<>();
        findPath(root , targetSum , new ArrayList<>(), result );

        return result ;

        
    }
    private void findPath(TreeNode node , int targetSum , List<Integer> currentPath , List<List<Integer>> result){
        if (node == null){
            return ;
        }
        currentPath.add(node.val);

        if (node.left ==null && node .right ==null && targetSum -node.val ==0){
            result.add(new ArrayList<>(currentPath));
        }else{
            findPath(node.left , targetSum-node.val , currentPath , result );
            findPath(node.right , targetSum -node.val , currentPath , result );

        }
        // backtrack 
        currentPath.remove(currentPath.size() - 1);
    } 
    
}

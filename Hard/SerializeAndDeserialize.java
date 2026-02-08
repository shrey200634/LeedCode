package Hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SerializeAndDeserialize {
    class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {}
    
    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

 public List<String> serialize(TreeNode root) {
    List<String > list = new ArrayList<>();
    helper(root, list);
    return list ;

        
    }
    void helper (TreeNode node , List<String > list ){
        if (node ==null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);

    }

    public TreeNode deserialize(List<String> list ) {
        Collections.reverse(list);
        TreeNode node = helper2(list);
        return node ;

        
    }

    TreeNode helper2(List<String > list){
        String val = list.remove(list.size()-1);
        if (val.charAt(0) =='n'){
            return null;
        }
        TreeNode node = new TreeNode (Integer.parseInt(val));
        node.left=helper2(list);
        node.right=helper2(list);

        return node ;
        


    }








    
}

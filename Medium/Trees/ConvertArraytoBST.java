package Medium.Trees;

public class ConvertArraytoBST {
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
 public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int nums[], int start, int end) {
        if (start>end) { 
            return null;
        }
        
        int mid = start +(end-start)/ 2; 
        TreeNode root = new TreeNode(nums[mid]); // mid value or median
        root.left = CreateBST(nums, start, mid - 1); 
                                                 // array
        root.right = CreateBST(nums, mid + 1, end); 
                                                  // array
        return root;
    }
    
}

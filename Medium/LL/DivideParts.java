package Medium.LL;

public class DivideParts {
     public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 
    }
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
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] ans = new ListNode[k];

        int size =0;
        ListNode current = head ;
        while ( current !=null){
            size++;
            current=current.next ;
          
        }
        int splitSize = size/k;

        int remaining = size %k;

        current = head ;
        ListNode prev = current ;
        for(int i =0 ; i<k;i++){
            ListNode newPart =current ;
            int currentSize = splitSize;
            if(remaining > 0){
                remaining--;
                currentSize++;
            }

            int j =0;
            while (j<currentSize){
                prev =current ;
                current=current.next;
                j++;
            }
            if (prev !=null){
                prev.next =null;
            }
            ans [i] =newPart;



        }
        return ans ;

      

        
    }
    
}

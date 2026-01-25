package Medium.LL;

public class swapNodes {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode firstNode = fast;
        ListNode secondNode = head;
        while (fast.next != null) {
        fast = fast.next;
            secondNode = secondNode.next;
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return head;
    }
    
}

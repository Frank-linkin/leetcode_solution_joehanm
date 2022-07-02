import dataStructrue.ListNode;

public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if( head == null ) return null;
        ListNode fast = head;
        while(fast.next !=null){
            if(fast.next.next != null)
                fast = fast.next.next;
            else
                fast = fast.next;
            head = head.next;
        }
        return head;
    }
}

public class Solution876 {
       public class ListNode {
           int val;
           ListNode next;
           ListNode(int x) { val = x; }
       }

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

public class Solution141 {

      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public boolean hasCycle(ListNode head) {
        //处理边界条件
        if(head == null) return false;
        if(head.next == head) return true;
        if(head.next == null) return false;
        ListNode fast=head.next,slow=head;
        while(slow !=null){
            slow = slow.next;
            if(fast.next ==null||fast.next.next==null){
                return false;
            }
            fast = fast.next.next;
            if(fast==slow||fast.next == slow){
                return true;
            }
        }
        return false;
    }
}

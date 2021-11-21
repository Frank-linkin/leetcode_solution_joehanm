import java.util.HashSet;

public class Solution142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null ) return null;
        if(head.next == null) return null;
        if(head.next == head) return head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != slow){
            if(fast==null||slow == null||fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while(head!=slow){
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }
}

import dataStructrue.ListNode;

import java.util.HashSet;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null ) {
            return head;
        }
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow ) {
                ListNode p = head;
                while(p!=slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    /**
     * 快指针，慢指针，快慢指针（加点便签，方便搜索）
     * 仔细想想fast确实一定会跟slow相遇
     *      ①假如fast落后slow一步,fast.next = slow:
     *          那么下一步，fast和slow就会相遇
     *      ②假设fast落后slow两步，fast.next.next = slow
     *          那么下一步，就会出现情况1的情形
     */
}

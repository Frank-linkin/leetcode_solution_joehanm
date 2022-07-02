import dataStructrue.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution21 {
    public void test(ListNode l1){
        ListNode p1 = l1;
        l1.val = 3;
        System.out.println(p1.val);
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        Solution21 p = new Solution21();
        p.test(a);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode p1,p2,head;
        if(l1.val>l2.val){
            p1 = l2;
            p2 = l1;
        }
        else{
            p1 = l1;
            p2 = l2;
        }
        head = p1;

        ListNode pre1 = null,next2=null;
        while(p1!=null&&p2!=null){
            while(p1!=null&&p1.val<=p2.val){
                pre1 = p1;
                p1=p1.next;

            }
            if(p1 == null){
                break;
            }
            pre1.next = p2;
            next2 = p2.next;
            p2.next = p1;
            pre1 = p2;
            p2 = next2;

        }

        if(p1 ==null&&p2!=null){
            pre1.next = p2;
            return head;
        }
        return head;
    }
}



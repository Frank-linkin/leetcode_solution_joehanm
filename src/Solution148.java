import dataStructrue.ListNode;
import org.junit.Test;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next==null){
            return head;
        }

        ListNode tail = head;
        while(tail.next!=null){
            tail=tail.next;
        }
        return biSort(head,tail);
    }

    public ListNode biSort(ListNode head,ListNode tail){
        if(head == tail){
            head.next=null;
            return head;
        }

        ListNode p = head,q = head;
        ListNode lastQ = null;
        while(p!=tail){
            lastQ = q;
            p = p.next;
            q = q.next;
            if(p!=tail&&p.next!=tail){
                p=p.next;
            }
        }
        ListNode l1 = biSort(head,lastQ);
        ListNode l2 = biSort(q,p);
        p = l1;
        q = l2;
        ListNode newHead = new ListNode();
        ListNode r= newHead;
        while(p!=null&&q!=null){
            if(p.val<q.val){
                r.next = p;
                p = p.next;
            }else{
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if(p!=null){
            r.next = p;
        }else if(q!=null){
            r.next = q;
        }
        return newHead.next;
    }

    @Test
    public void test1(){
        ListNode head = new ListNode(7);
        ListNode p =head;
        p.next = new ListNode(3);
        p=p.next;

        p.next = new ListNode(2);
        p=p.next;

        p.next = new ListNode(5);
        p=p.next;
        ListNode sorted=sortList(head);
        printList(sorted);
    }

    public void printList(ListNode head){
        while(head!=null){
            System.out.printf("%d ",head.val);
            head = head.next;
        }
        System.out.println();
    }
}

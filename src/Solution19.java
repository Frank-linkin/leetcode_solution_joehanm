import dataStructrue.ListNode;
import org.junit.Test;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        while(p!=null&&n-->0){
            p=p.next;
        }
 
        if(p==null){
            return n==0?head.next:null;
        }

        ListNode k = head;
        while(p.next!=null){
            p = p.next;
            k = k.next;
        }
        k.next=k.next.next;
        return head;
    }



    @Test
    public void test1(){
        ListNode L1 ;
        int[] data1 = {9,3,9,0,9,9};

        ListNode p = new ListNode();
        Solution19 solution19 = new Solution19();
        L1 = p;
        for(int i = 0 ; i < data1.length ;i ++){
            p.next = new ListNode(data1[i]);
           // System.out.printf("%d ",p.val);
            p=p.next;
        }
        L1 = L1.next;

        solution19.showLinkList(solution19.removeNthFromEnd(L1,3));
    }

    public void showLinkList(ListNode head){
        while(head!=null){
            System.out.printf("%d ",head.val);
            head = head.next;
        }
        System.out.println();
    }
}

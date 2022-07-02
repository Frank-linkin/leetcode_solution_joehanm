import dataStructrue.ListNode;
import org.junit.Test;

public class Solution61 {

    /**
     * k > len k = k % len
     * 之后
     * step = len - k
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        //处理边界条件
        if(head == null ) return null;
        if(head.next == null ) return head;

        int len = 0;
        ListNode p = head;
        while(p!=null) {
            len++;
            p = p.next;
        }
        k = k % len;
        if(k==0) {
            return head;
        }
        int step = len - k;
        p = head;
        ListNode lastP = null;
        while(step>0) {
            step--;
            lastP = p;
            p = p.next;
        }
        while(p.next !=null) {
            p = p.next;
        }
        p.next = head;
        head = lastP.next;
        lastP.next = null;
        return head;
    }


    @Test
    public void test1(){

        int[] data = {1,2,3,4,5};
        int k = 1;

        ListNode p = new ListNode();
        ListNode L1 = p;
        for(int i = 0 ; i < data.length ;i ++){
            p.next = new ListNode(data[i],null);
            // System.out.printf("%d ",p.val);
            p=p.next;
        }
        L1 = L1.next;

        showLinkList(L1);
        showLinkList(rotateRight(L1,k));
    }

    public void showLinkList(ListNode head){
        while(head!=null){
            System.out.printf("%d ",head.val);
            head= head.next;
        }
        System.out.println();
    }
}

import org.junit.Test;

public class Solution61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        //处理一些边界条件
        if(head==null)
            return null;
        if(k==0)
            return head;

        ListNode p = head;
        int length = 1;
        while(p.next != null){
            p = p.next;
            length++;
        }
        p.next = head;

        k= k%length;k = length - k;k--;
        p=head;
        while(k-->0){
            p=p.next;
        }
        ListNode res = p.next;
        p.next=null;
        return res;
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

import org.junit.Test;

public class Solution25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
      if(head == null ) {
          return null;
      }
      if(k==1) {
          return head;
      }

      ListNode newHead = new ListNode();
      newHead.next = head;

      ListNode start=head,end=head,lastTail = newHead;
      while(end!=null) {
          int step = 0 ;
          while(end != null && step!=k) {
              end = end.next;
              step++;
          }
          ListNode newTail =null;
          if(step==k) {
              newTail = start;
              //翻转head到end之前的结点
              lastTail.next = reverse(start,end);
              lastTail = newTail;
              start = end;
          }
          else{
              return newHead.next;
          }
      }
      return newHead.next;
    }

    public ListNode reverse(ListNode head ,ListNode end) {
        ListNode newHead = new ListNode(-1);
        newHead.next = end;
        while(head!=end){
            ListNode tem  = head;
            head = head.next;
            tem.next = newHead.next;
            newHead.next = tem;
        }
        return newHead.next;
    }

    @Test
    public void test1(){
        Solution25 solution25 = new Solution25();
        int[] data = {1,2,3,4,5,6,7,8,9};
        int k = 4;

        ListNode p = new ListNode();
        ListNode L1 = p;
        for(int i = 0 ; i < data.length ;i ++){
            p.next = new ListNode(data[i],null);
            // System.out.printf("%d ",p.val);
            p=p.next;
        }
        L1 = L1.next;

        ListNode afterReverse = solution25.reverseKGroup(L1,k);
        showLinkList(afterReverse);
    }

    public void showLinkList(ListNode head){
        while(head!=null){
            System.out.printf("%d ",head.val);
            head= head.next;
        }
        System.out.println();
    }
}

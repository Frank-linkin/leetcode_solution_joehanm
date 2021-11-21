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
        if(head == null){
            return null;
        }
        if(k==1){
            return head;
        }

        //初始化
        ListNode newHead,poineer = head,p=poineer,nowTail=null;
        newHead = new ListNode(0,head);
        ListNode lastTail = newHead;
        ListNode reverseList = new ListNode(0);
        ListNode tem;
        //开始算法过程
        int step;
        while(true){
            step=k;
            while(poineer !=null&&step-->0)
                poineer = poineer.next;
            //情况一：poineer==null&&step==0代表运行到整个链表的末尾，且链表n%k==0
            //情况二：poineer==null&&stet>0则代表n%k!=0
            if(poineer==null&&step>0){
                lastTail.next = p;
                break;
            }

            //下一步要加上对情况一的处理
            nowTail=p;
            while(p!=poineer){
                tem = p.next;
                p.next = reverseList.next;
                reverseList.next = p;
                p=tem;
            }
            lastTail.next = reverseList.next;
            lastTail = nowTail;

            if(poineer == null&&step==0){
                lastTail.next = null;
                break;
            }
        }
        return newHead.next;
    }

    @Test
    public void test1(){
        Solution25 solution25 = new Solution25();
        int[] data = {1,2,3,4,5,6,7,8,9};
        int k = 10;

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

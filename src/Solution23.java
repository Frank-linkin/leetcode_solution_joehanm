import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> PQueue = new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode p :lists){
            if(p!=null)
                PQueue.add(p);
        }
        if(PQueue.isEmpty()){
            return null;
        }
        ListNode tail = PQueue.poll();
        ListNode head= tail;
        if(tail.next!=null)
            PQueue.add(tail.next);
        while(!PQueue.isEmpty()){
            tail.next = PQueue.poll();
            //          System.out.printf("%d",tail.next.val);
            tail = tail.next;
            if(tail.next!=null){
                PQueue.add(tail.next);
            }
        }
        return head;
    }

    @Test
    public void test1(){
        //这是对comparator的测试
        PriorityQueue<ListNode> PQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        PQueue.add(new ListNode(2));
        PQueue.add(new ListNode(3));
        System.out.printf("%d",PQueue.poll().val);
    }
}

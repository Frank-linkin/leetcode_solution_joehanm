import org.junit.Test;

import java.util.jar.JarOutputStream;

public class Solution2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //首先对边界条件进行处理
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        //写出函数体的主要内容
        //  初始化
        int carry = 0;
        ListNode root = l1;
        int result = l1.val+l2.val;
        if(result>=10){
            result-=10;
            carry = 1;
        }
        else{
            carry = 0;
        }
        l1.val = result;
        ListNode last = l1;
        l1=l1.next;
        l2=l2.next;

        // 函数的主体
        while(l1!=null||l2!=null||carry==1){
            if(l1==null){
                l1 = new ListNode(0,null);
            }

            result = l1.val+(l2==null?0:l2.val)+carry;
            //System.out.printf("%d+%d=%d ", l1.val,l2.val,result);
            if(result>=10){
                result-=10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            l1.val = result;

            last.next = l1;
            last = l1;
            l1=l1.next;
            if(l2!=null){
                l2= l2.next;
            }
        }
        return root;
    }

    @Test
    public void test1(){
        ListNode L1 ;
        ListNode L2 ;
        int[] data1 = {9,3,9,0,9,9};
        int[] data2 = {2,4,1,9};

        ListNode p = new ListNode(0);
        L1 = p;
        for(int i = 0 ; i < data1.length ;i ++){
            p.next = new ListNode(data1[i]);
            p=p.next;
        }
        L1 = L1.next;

        p = new ListNode(0);
        L2 = p;
        for(int i = 0 ; i < data2.length ;i ++){
            p.next = new ListNode(data2[i]);
            p=p.next;
        }
        L2 = L2.next;

        Solution2 solution2 = new Solution2();
        ListNode res=solution2.addTwoNumbers(L1,L2);

        p=res;
        while(p!=null){
            System.out.printf("%d ",p.val);
            p=p.next;
        }

    }


}

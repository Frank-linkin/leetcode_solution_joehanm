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

    //Version1 2021/03
    public ListNode addTwoNumbers_version1(ListNode l1, ListNode l2) {
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

    //2022年3月4日22:37:57
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1 == null ) {
            return l2;
        }
        if( l2 == null ) {
            return l1;
        }

        ListNode recycleHead = l2;
        ListNode resp = l1;
        ListNode lastL1 = null;
        boolean carryFlag = false;
        while( (l1!=null||l2!=null)||carryFlag==true) {
            if( l1 == null ) {
                if(recycleHead != null ) {
                    lastL1.next = recycleHead;
                    recycleHead.val = 0;
                    recycleHead = recycleHead.next;
                    l1 = lastL1.next;
                    l1.next =null;
                }
                else{
                    l1 = lastL1.next = new ListNode(0);
                }
            }

            int num = l1.val + (l2==null?0:l2.val) + (carryFlag?1:0);
            if(num>=10){
                num -= 10;
                carryFlag =true;
            }
            else{
                carryFlag = false;
            }

            l1.val = num;

            lastL1 = l1;
            l1 = l1.next;
            if( l2 != null ) {
                l2 = l2.next;
            }
        }
        return resp;
    }

    @Test
    public void test1(){
        ListNode L1 ;
        ListNode L2 ;
        int[] data1 = {1};
        int[] data2 = {9,9,9,1};

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

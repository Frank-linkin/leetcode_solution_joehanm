package utils;

import java.util.ArrayList;

public class ArrayAndList {
    /**
     * 将[]类型转化为list类型
     * @param array
     * @return
     */
    public ListNode arrayToList(Integer[] array){
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        for(Integer a:array) {
            p.next = new ListNode(a);
            p = p.next;
        }
        return newHead.next;
    }


    /**
     * 这个函数平常自己写写比较好，将List对象转化为数组。
     * @param head
     * @return
     */
    public Integer[] listToArray(ListNode head) {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        while(head!=null) {
            arraylist.add(head.val);
        }
        return arraylist.toArray(new Integer[0]);
    }

    public ListNode[] arraysToLists(Integer[][] arrays) {
        ListNode[] resp = new ListNode[arrays.length];

        for(int i = 0; i< arrays.length ; i++ ) {
            resp[i] = arrayToList(arrays[i]);
        }
        return resp;
    }
}

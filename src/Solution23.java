import dataStructrue.ListNode;
import org.junit.Test;

import utils.*;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0 ) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }

        Heap heap = new Heap(lists.length);
        for(int i = 0 ; i< lists.length ; i++ ) {
            if(lists[i] !=null ) {
                heap.heapAdd(lists[i],i);
                lists[i] = lists[i].next;
            }
        }
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while(!heap.isEmpty()) {
            heap.showHeap();
            System.out.println();
            HeapNode a = heap.heapPoll();
            p.next = a.data;

            if(lists[a.listIndex] !=null) {
                heap.heapAdd(lists[a.listIndex],a.listIndex);
                lists[a.listIndex] = lists[a.listIndex].next;
            }
            p = p.next;
        }
        return newHead.next;
    }



    //手动实现个小根堆
    class Heap {
        public HeapNode[] array;
        public int capacity;
        public int pos;

        public Heap() {
            this.array = new HeapNode[64];
            this.capacity = 64;
            this.pos = 0;
        }

        public Heap(int size) {
            this.array = new HeapNode[size];
            this.capacity = size;
            this.pos = 0;
        }
        public HeapNode heapAdd (ListNode val,Integer listIndex) {
            if(this.pos == this.capacity) {
                enlargeCapacity();
            }

            HeapNode heapNode = new HeapNode(val,listIndex);
            this.array[this.pos] = heapNode;

            //开始对堆进行调整
            retateUp();

            this.pos++;
            return array[0];
        }




        public HeapNode heapPoll() {
            if(pos==0) {
                return null;
            }
            HeapNode resp = array[0];
            array[0] = array[pos-1];
            this.pos--;
            retateDown();

            return resp;
        }

        private void retateUp() {
            if(this.pos >0 ){
                int p = this.pos;
                int parentP = (p-1)>>1;
                while(parentP>=0 && array[parentP].data.val >array[p].data.val) {
                    swap(parentP,p);

                    p = parentP;
                    parentP = (parentP-1)/2;
                }
            }
        }



        private void retateDown(){
            if(this.pos > 1 ) {
                int p = 0;
                int leftChild = 2*p+1;
                int rightChild = 2*p+2;
                while(leftChild < this.pos || rightChild < this.pos) {
                    if(array[rightChild] == null) {
                        if(array[leftChild].data.val <array[p].data.val){
                            swap(p,leftChild);
                            p = leftChild;
                        }else{
                            break;
                        }
                    }

                    if(array[leftChild].data.val <= array[rightChild].data.val){
                        if(array[leftChild].data.val <array[p].data.val) {
                            swap(leftChild,p);
                            p = leftChild;
                        } else{
                          break;
                        }

                    }
                    else{
                        if(array[rightChild].data.val <array[p].data.val) {
                            swap(rightChild, p);
                            p = rightChild;
                        }else{
                            break;
                        }
                    }

                    leftChild = 2*p+1;
                    rightChild = 2*p+2;
                }
            }
        }

        public Boolean isEmpty(){
            return this.pos==0?true:false;
        }

        public void showHeap(){
            System.out.printf("Heap:");
            for(HeapNode a : this.array) {
                System.out.printf("%d ",a.data.val);
            }
        }
        private void swap(int x,int y) {
            HeapNode tem = array[x];
            array[x] = array[y];
            array[y] = tem;
        }

        private void enlargeCapacity(){
            HeapNode[] newArray = new HeapNode[capacity*2];
            for(int i = 0 ; i< pos;i++) {
                newArray[i] = array[i];
            }

            this.array = newArray;
        }
    }

    class HeapNode{
        ListNode data;
        int listIndex;

        public HeapNode(){
        }

        public HeapNode(ListNode data) {
            this.data = data;
        }

        public HeapNode(ListNode data,Integer listIndex) {
            this.data = data;
            this.listIndex = listIndex;
        }
    }


    @Test
    public void heapTest(){
        Heap heap = new Heap(4);

        while(!heap.isEmpty()) {
            System.out.println(heap.heapPoll()+" ");
        }

    }

    @Test
    public void test1(){
//        //这是对comparator的测试
//        PriorityQueue<ListNode> PQueue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//        PQueue.add(new ListNode(2));
//        PQueue.add(new ListNode(3));
//        System.out.printf("%d",PQueue.poll().val);

        Integer[][] arrays = {
                {-3,2,2},
                {-9},
                {-10,-5,-4,-2,-1,1,3,4},
                {-10,-9,-8,3,4},
                {-5,-3,3,4},
                {-9,-8,-5,-4,-2,-1,3}
        };
        ArrayAndList utils = new ArrayAndList();
        ListNode newList = mergeKLists(utils.arraysToLists(arrays));
        newList.showLinkedList();
    }



}

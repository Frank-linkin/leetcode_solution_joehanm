import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {

    @Test
    public void test1(){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        private Queue<Integer> q;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<Integer>();
            q2 = new LinkedList<Integer>();
            q = q1;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(q1.isEmpty()){
                q2.offer(x);
            }
            else{
                q1.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int tem;
            if(q1.isEmpty()){
                while(q2.size()>1){
                    tem = q2.poll();
                    q1.offer(tem);
                }
                return q2.poll();
            }

            else{
                while(q1.size()>1){
                    tem = q1.poll();
                    q2.offer(tem);
                }
                return q1.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            int tem;
            if(q1.isEmpty()){
                while(q2.size()>1){
                    tem =q2.poll();
                    q1.offer(tem);
                }
                tem = q2.poll();
                q1.offer(tem);
                return tem;
            }
            else{
                while(q1.size()>1){
                    tem = q1.poll();
                    q2.offer(tem);
                }
                tem = q1.poll();
                q2.offer(tem);
                return tem;
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty()&&q2.isEmpty();
        }
    }
}

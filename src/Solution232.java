import java.util.Stack;

public class Solution232 {
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;


        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while(stack1.size()>1){
                stack2.push(stack1.pop());
            }
            int tem = stack1.pop();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return tem;
        }

        /** Get the front element. */
        public int peek() {
            while(stack1.size()>1){
                stack2.push(stack1.pop());
            }
            int tem = stack1.peek();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return tem;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty();
        }
    }

}

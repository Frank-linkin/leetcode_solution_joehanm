import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution946 {
    //开始：10:11
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();

        int p = 0,q=0;
        while(q<popped.length){
            while(p<pushed.length&&(stack.size()==0||stack.getLast()!=popped[q])) {
                stack.addLast(pushed[p]);
                p++;
            }
            if(p==pushed.length&&stack.getLast()!=popped[q]){
                return false;
            }

            while(q<popped.length&&stack.size()!=0&&stack.getLast()==popped[q]){
                stack.pollLast();
                q++;
            }
        }
        return true;
    }

    @Test
    public void test1(){
        int[] pushed = {1,2,3,4,5};
        int[] popped = {1,2,3,4,5};
        System.out.println(validateStackSequences(pushed,popped));
    }
    /**
     *  pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     *  pushed = [1,2,3,4,5], popped = [4,5,3,1,2]
     *
     *  思路一：使用一个栈模拟
     *  思路二：
     */
}

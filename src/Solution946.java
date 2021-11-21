import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
            int len  = pushed.length;
            int i = 0,p=0;
            Deque<Integer> stack = new ArrayDeque<Integer>();
            while(true){
                while(i<len&&(stack.isEmpty()||stack.peek()!=popped[p])){
                    stack.push(pushed[i]);
                    i++;
                }
                while(!stack.isEmpty()&&stack.peek()==popped[p]){
                    stack.poll();
                    p++;
                }
                if(i==len){
                    if (p==len)
                        return true;
                    return false;
                }
            }
    }

    @Test
    public void test1(){
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
}

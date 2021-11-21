import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0  ; i < T.length ; i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int tem = stack.pop();
                ans[tem] = i - tem;
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void test1(){

    }
}

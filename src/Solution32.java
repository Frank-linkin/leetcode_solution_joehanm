import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        //边界条件处理
        if(s==null) return 0;
        int len = s.length();
        if(len==1||len==0) return 0;
        //一会把len统一用一个常量替代

        int[] maxLen = new int[len];
        maxLen[0] = 0;
        int max = 0;
        Deque<Character> stack = new ArrayDeque<Character>();
        stack.add(s.charAt(0));
        for(int i = 1 ; i <len ; i++){
            char now = s.charAt(i);
            if(now=='('){
                stack.push(now);
                if(s.charAt(i-1)=='(')
                    maxLen[i] = 0;
                else
                    maxLen[i] = maxLen[i-1];
            }
            if(now==')'){
                if(!stack.isEmpty()&&stack.peek()=='('){//stack空的时候是不能使用peek()的
                    stack.pop();
                    if(s.charAt(i-1)=='(')
                        maxLen[i] = maxLen[i-1]+2;
                    else{
                        maxLen[i] = maxLen[i-1]+maxLen[i-maxLen[i-1]-1]+2;
                    }
                }
                else
                    maxLen[i] = 0;
                if(maxLen[i]>max){
                    max = maxLen[i];
                }
            }

        }
        return max;
    }

    @Test
    public void test1(){
        String s  = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<=1) {
            return 0;
        }

        int left = 0,right=0,maxLen = 0;
        //从左向右遍历
        for(int i =0 ; i< s.length();i++) {
            char curChar = s.charAt(i);
            if(curChar == '(') {
                left++;
            }else {
                right++;
            }

            if(left==right) {
                maxLen = maxLen<(right+left)?(right+left):maxLen;
            }else if(right>left){
                right = 0;
                left = 0;
            }
        }

        //从右向左遍历
        right=0;
        left=0;
        for(int i = s.length()-1 ; i>=0 ;i--) {
            char curChar = s.charAt(i);
            if(curChar == '(') {
                left++;
            }else {
                right++;
            }

            if(left==right) {
                maxLen = maxLen<(right+left)?(right+left):maxLen;
            }else if(right<left){
                right = 0;
                left = 0;
            }
        }
        return maxLen;
    }

    @Test
    public void test1(){
        String s  = ")()())";
        System.out.println(longestValidParentheses(s));
    }
    /**
     * 思路一：
     *  使用一个栈记录括号，
     *      (时，入栈，)判断栈顶元素是不是(不是，则不是有效括号
     *  使用一个curLen和maxLen变量
     *      （）（）（（））
     *  dp[i]表示以i为末尾的括号 成功结束 最长有效括号的长度。
     *      遇到(入栈，dp[i]= 0
     *      遇到(出栈，dp[i]=dp[出来的(的index]+(i-index+1)
     *              同时还要验证dp[i-1]是否等于i-index-1
     *
     *  思路二：
     *      使用left表示(截止i，left的数量，right表示截止i，right的数量)
     *      首先从左向右遍历
     *          right>left,curLen = 0
     *          right==left,得到现在的最大长度，right,left归零
     *      但是只遍历一遍的话，会有一个问题：
     *          (((()),left始终比right大的情况计算不出来。
     *
     *      考虑再进行一轮从右向左的遍历
     *          可以获得另一个maxLen
     *       取两次遍历中，最大的len为最大长度。

     */
}

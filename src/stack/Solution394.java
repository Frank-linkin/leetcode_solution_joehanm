package stack;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Solution394 {
    int point;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        point=0;

        while(point<s.length()){
            char cur = s.charAt(point);
            if(Character.isDigit(cur)){
                String digits = getDigits(s);
                stk.addLast(digits);
            }
            else if(Character.isLetter(cur)||cur=='['){
                //获取一个字母并且进栈
                stk.addLast(String.valueOf(s.charAt(point++)));
            }
            else{
                ++point;
                LinkedList<String> sub = new LinkedList<String>();
                while(!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                //左括号出栈
                stk.removeLast();
                //此时栈顶为当前sub对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                //构造字符串
                while(repTime-->0){
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    public String getDigits(String s){
        StringBuffer ret = new StringBuffer();
        while(Character.isDigit(s.charAt(point))){
            ret.append(s.charAt(point++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    @Test
    public void test1(){
        System.out.println((int)'0');
        System.out.println((int)'9');
    }

}

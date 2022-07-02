import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if( s== null || s.length() == 0) {
            return 0;
        }
        if( s.length()==1 ) {
            return 1;
        }

        boolean[] hash = new boolean[128];
        int start = 0,end =1;
        hash[s.charAt(0)]=true;
        int len = 1;
        while( end< s.length() ) {
            Character now = s.charAt(end);
            if(hash[now]) {
                while( hash[now]){
                    hash[s.charAt(start)] = false;
                    start++;
                }
            }
            hash[now]=true;
            len = len<(end-start+1)?(end-start+1):len;
            end++;
        }
        return len;
    }

    @Test
    public void test1(){
        String s1 = "abcabcaaa";
        String s2 = "pwwkew";
        Solution3 solution=new Solution3();
        System.out.println(solution.lengthOfLongestSubstring(s1));
        System.out.println(solution.lengthOfLongestSubstring(s2));
        System.out.println(s1.substring(1,3).lastIndexOf('c'));
    }

    @Test
    public void test2(){
        //将部分或者全部字符数组转化为String()
        char[] data = {'x','y','z','o'};
        String str = new String(data,1,2);
        System.out.println(str);

        String str2 = new String(data);
        System.out.println(str2);

        //将部分或全部String转化为字符数组
        String str1 = "abcDEFghi";
        char[] chars = str1.substring(2,5).toCharArray();
        for(char a : chars){
            System.out.printf("%c",a);
        }
    }


}

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring_version1(String s) {
        //首先处理边界条件
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        //进入到函数处理步骤
        int len = s.length();
        int b = 0 ,e = 0;//b(egin),e(end)
        int maxLen = 0;
        Set<Character> hashSet = new HashSet<>();
        for(b=0;b<len;b++){
            while(b>e){
                hashSet.remove(s.charAt(e));
                e++;
            }
            hashSet.add(s.charAt(b));

            while(e<len-1&&!hashSet.contains(s.charAt(e+1))){
                e++;
                hashSet.add(s.charAt(e));
            }
            System.out.printf("e = %d,b = %d",e,b );
            if( (e - b + 1)> maxLen){
                maxLen = (e - b + 1);
            }
            System.out.println();
            hashSet.remove(s.charAt(b));
        }

        return maxLen;
    }

    //version2 2021年12月10日22:41:53
    public int lengthOfLongestSubstring(String s) {
        if( s== null || s.length() == 0 ) {
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int[] lastAppear = new int[128];
        for( int i = 0 ; i <128 ; i++ ) {
            lastAppear[i] = -1;
        }
        int maxLength = -1;
        int startIndex = 0;
        for(int i = 0 ; i < s.length() ; i++ ) {
            char tem = s.charAt(i);
            if( lastAppear[(int)tem] == -1 ) {
                lastAppear[(int)tem] = i;
                maxLength = maxLength>(i-startIndex+1)?maxLength:(i-startIndex+1);
            }
            else{
                for(;startIndex<=lastAppear[(int)tem];startIndex++){
                    lastAppear[s.charAt(startIndex)] = -1;
                }

                lastAppear[(int)tem] = i;
            }
        }
        return  maxLength;
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

}

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<Integer>();
        if ( s== null || s.length() == 0 ) {
            return list;
        }
        int[] hash = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            System.out.printf("%c ",s.charAt(i));
            hash[(s.charAt(i)-'a')] = i;
        }

        int start = 0, end = 0;
        for (int i = 0 ; i <= s.length(); i++) {
            if(i>end) {
                list.add(end- start + 1);
                start = i;

                if(i==s.length()) {
                    break;
                }
            }

            if(hash[s.charAt(i)-'a']>end) {
                end = hash[s.charAt(i)-'a'];
            }
        }
        return list;
    }
    @Test
    public void test1(){
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
    /**
     * 首先遍历s
     *  记下每个字母最末出现的位置
     *  然后再遍历一遍
     *      用字母最末出现的位置更新end
     */
}

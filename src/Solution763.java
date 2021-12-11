import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution763 {
    //version_202104
    public List<Integer> partitionLabels_version1(String S) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap map = new HashMap<Character,Integer>();
        int start = -1,end = -1;
        int last = -1;
        for(int i = 0 ; i < S.length() ; i++){
            char cur = S.charAt(i);
            if(i==end){
                res.add((i-start+1));
                map = new HashMap<Character,Integer>();
                continue;
            }
            if(map.isEmpty()){
                start  = i;
                end = S.lastIndexOf(cur);
                if(start == end){
                    res.add((i-start+1));
                    map = new HashMap<Character,Integer>();
                    continue;
                }
                map.put(cur,end);
            }
            else{
                if(!map.containsKey(cur)){
                    last = S.lastIndexOf(cur);
                    map.put(cur,last);
                    end=last>end?last:end;
                }
            }
        }
        return res;
    }

    //version 20211205
    //记录每个字符最后出现的位置lastIndex[]
    //targetIndex标志着，扫描到这个位置，就证明这个可以被切分成一个partition
    //startIndex：此partition起始坐标
    public List<Integer> partitionLabels(String s) {
        int startIndex = 0,targetIndex = -1;
        int[] lastIndex = new int[26];
        for(int i = 0 ; i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }

        ArrayList<Integer> resp = new ArrayList<>();
        for(int i = 0 ;i < s.length() ; i++){
            targetIndex = lastIndex[s.charAt(i)-'a']>targetIndex?lastIndex[s.charAt(i)-'a']:targetIndex;
            if(i==targetIndex){
                resp.add(targetIndex-startIndex+1);
                startIndex = targetIndex+1;
                targetIndex = -1;
            }
        }
        return resp;
    }
    @Test
    public void test1(){
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}

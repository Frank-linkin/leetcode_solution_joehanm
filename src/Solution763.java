import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
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
    @Test
    public void test1(){
        String s = "zabcabdeffghgdl";
        System.out.println(partitionLabels(s));
    }
}

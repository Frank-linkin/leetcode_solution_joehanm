import java.sql.Array;
import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> resp = new ArrayList<List<String>>();
        if ( strs == null || strs.length == 0) {
            return resp;
        }

        HashMap<Integer,List<String>> map  = new HashMap<>();
        for(String s : strs) {
            int num = transforToInt(s);
            if(map.containsKey(num)) {
                List<String> list = map.get(num);
                list.add(s);
            }
            else{
                List<String> list = new LinkedList<String>();
                list.add(s);
                map.put(num,list);
            }
        }

        resp.addAll(map.values());
        return resp;
    }
    public int transforToInt(String str) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        int resp = 0;
        for(char c :s) {
            resp = resp*26+(c-'a'+1);
        }
        return resp;
    }

    /**
     * 思路：
     *      转换成一个数字
     *      特别注意：
     *          当以a为开头的时候，ac计算出的值不能和c相等，所以要用27进制
     */
}

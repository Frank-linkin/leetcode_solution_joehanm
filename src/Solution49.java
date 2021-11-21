import java.sql.Array;
import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str : strs){
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            String key =  new String(cstr);
            List<String> list = map.getOrDefault(key,new LinkedList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new LinkedList<List<String>>(map.values());
    }
}

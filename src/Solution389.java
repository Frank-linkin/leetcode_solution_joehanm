import java.util.HashMap;
import java.util.HashSet;

public class Solution389 {

    public static void main(String[] args) {
        String a1 = "abc";
        String a2 = "adbc";

        Solution389 c = new Solution389();
        System.out.println(c.findTheDifference(a1,a2));
    }
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char a:s.toCharArray()){
            if(map.containsKey(a)){
                int tem = map.get(a);
                tem++;
                map.put(a,tem);
            }
            else{
                map.put(a,1);
            }
        }

        int count;
        for(char a:t.toCharArray()){
            if(map.containsKey(a)){
                count = map.get(a);
                count--;
                map.put(a,count);
            }else{
                return a;
            }

        }

        for(char a:map.keySet()){
            if(map.get(a)==1){
                return a;
            }
        }
        return 'a';
    }
}

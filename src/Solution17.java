import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution17 {
    //11:27-开始
    public List<String> letterCombinations(String digits) {
        LinkedList<String> resp = new LinkedList<>();
        if(digits == null || digits.length()==0) {
            return resp;
        }
        int[] map = {0,3,6,9,12,15,19,22,26};
        StringBuilder cur = new StringBuilder();
        //        for(int i = 0 ; i< intToChar.length-1; i++ ) {
//            int p = intToChar[i];
//            while(p<intToChar[i+1]){
//                System.out.printf("%c ",p+'a');
//                p++;
//            }
//            System.out.println();
//        }
        generateSequence(map,0,digits,cur,resp);

        return resp;
    }

    public void generateSequence(int[] map,int index,String digits,StringBuilder cur,LinkedList<String> resp){
        if(index>=digits.length()) {
            resp.addLast(cur.toString());
            return;
        }
        int digit = digits.charAt(index)-'0';
        digit-=2;
        for(int i = map[digit];i<map[digit+1];i++) {
            cur.append((char)('a'+i));
            generateSequence(map,index+1,digits,cur,resp);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    @Test
    public void test1(){
        System.out.println(letterCombinations("22"));
    }
    /**
     * 2 - abc
     * 3 - def
     * 4 - ghi
     * 5 - jkl
     */
}

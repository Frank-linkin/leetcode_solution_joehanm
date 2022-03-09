import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    /**
    length = n
    一开始使用s = s.concat方法，这种明显效率很差
     所以后来使用了Sring buffer的append方法，效率体上升了很多
     */
    public String intToRoman(int num) {
        Map<Integer,Character> hashmap = new HashMap<>();
        hashmap.put(1,'I');
        hashmap.put(5,'V');
        hashmap.put(10,'X');
        hashmap.put(50,'L');
        hashmap.put(100,'C');
        hashmap.put(500,'D');
        hashmap.put(1000,'M');

        int rank = 1000;
        StringBuffer s = new StringBuffer();

        while(rank != 0 ) {
            int tem = num/rank;
            //System.out.println(hashmap.get(rank).toString());
            if(tem  == 9 ) {
                s.append( hashmap.get(rank));
                s.append(hashmap.get(10*rank));
            }
            else if(tem  == 4 ) {
                s.append(hashmap.get(rank));
                s.append(hashmap.get(5*rank));
            }
            else if(tem  >= 5 ) {
                s.append(hashmap.get(5*rank));
                for(int i = 0;  i< tem-5; i ++ ) {
                    s.append(hashmap.get(rank));
                }
            }
            else if(tem  < 5 ){
                for( int i = 0 ; i < tem; i++ ) {
                    s.append(hashmap.get(rank));
                }
            }

            if( tem != 0 ) {
                num = num - (tem*rank);

            }
            rank /= 10;
        }
        return s.toString();

    }

    @Test
    public void test1(){
        int a = 27;
        System.out.println(intToRoman(a));
    }

}

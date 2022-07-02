import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution6 {
    public String convert(String s, int numRows) {
        if(s==null||s.length() ==0 ){
            return s;
        }
        if(numRows == 1) {
            return s;
        }

        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i = 0 ; i< builders.length ; i++ ) {
            builders[i] = new StringBuilder();
        }
        boolean isDescend = true;
        int i = 0;
        for(Character a: s.toCharArray()){
            builders[i].append(a);

            if(i==0) {
                isDescend = true;
            }
            if(i==numRows-1){
                isDescend = false;
            }
//            System.out.printf("%d ",i);
            i = isDescend?(i+1):(i-1);
        }
        StringBuilder resp = new StringBuilder();
        for(StringBuilder a: builders) {
            resp.append(a);
        }
        return resp.toString();
    }
    @Test
    public void main() {
        String s = "PAYPALISHIRING";
        int minRows = 3;
        System.out.println(convert(s,3));

    }
    /**
     * 控制指针在矩形上的移动，来产生zifuchaun
     * 因为java中有StringBuilder，建立numRows的StringBuild
     * 指针P
     *      if( p == 0 ){
     *          descend = true;
     *      }
     *      if( p == numRows)
     *          descend = flase;
     */
}
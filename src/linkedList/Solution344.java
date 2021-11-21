package linkedList;

public class Solution344 {
    public void reverseString(char[] s) {
        int left = 0,right = s.length;
        char tem;
        while(left<right){
            tem = s[left];
            s[left] = s[right];
            s[right] = tem;
        }
    }
}

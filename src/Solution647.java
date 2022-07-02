import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class Solution647 {
    //中心扩展法
    public int countSubstrings(String s){
        if(s==null || s.length() == 0) {
            return 0;
        }

        char[] charArr = s.toCharArray();
        int count = 0;
        for(int i = 0 ; i <charArr.length ; i++ ) {
            //检查以charArr[i]为中心的
            int left=i, right = i;
            while(left>=0&&right<charArr.length&&charArr[left]==charArr[right]) {
                left--;
                right++;
                count++;
            }

            left=i;
            right = i +1;
            while(left>=0&&right<charArr.length&&charArr[left]==charArr[right]) {
                left--;
                right++;
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1(){
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}

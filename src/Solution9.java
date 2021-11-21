import org.junit.Test;

public class Solution9 {
    public boolean isPalindrome(int x) {
        int p = 0;
        int sim = x;
        while(sim!=0){
            p*=10;
            p=p+(sim%10);
            sim/=10;
        }
        System.out.println(p);
        p=p<0?-p:p;
        if(p==x){
            return true;
        }
        else
            return false;
    }

    @Test
    public void test1(){
        int p = -2112;
        System.out.println(isPalindrome(p));
        int q = -99;
        System.out.println(-99%10);
    }
}

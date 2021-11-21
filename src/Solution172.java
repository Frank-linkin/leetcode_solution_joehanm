import org.junit.Test;

public class Solution172 {
    public int trailingZeroes(int n) {
        int fenmu = 5;
        int res = 0;
        while(n/fenmu!=0){
            res += n/fenmu;
            fenmu*=5;
        }
        return res;
    }

    @Test
    public void test1(){
        System.out.println(trailingZeroes(26));
    }
}

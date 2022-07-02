import org.junit.Test;

public class Solution172 {
    public int trailingZeroes(int n) {
        int times = n/5;
        return calculateSum(times);
    }

    public int calculateSum(int num) {
        int resp = 0;
        if((num&1) ==1) {
            int tem = (num-1)/2;
            resp = tem*(num+1)+((num+1)/2);
        }
        else{
            resp = (num/2)*(num+1);
        }
        return resp;
    }

    @Test
    public void test1(){
        System.out.println(trailingZeroes(26));
    }
    /**
     * 可以直接计算里里面有多少个5
     * 5！里里面有1个5
     * 10！里面有2+1个5
     * 15！里面有3+2+1个5
     */
}

public class Solution343 {
    public int integerBreak(int n) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        int max = -1;
        for(int i = 1; i< (n>>1)+1;i++) {
            int result1=integerBreak(i);
            int result2 = integerBreak(n-i);

            int curResult = (i>result1?i:result1)*((n-i)>result2?(n-i):result2);
            max = max<curResult?curResult:max;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution343 solution343 = new Solution343();

        System.out.println(solution343.integerBreak(10));
    }
    /**
     * 思路：
     *  将数分别分割为[1,n-1],[2,n-1]
     */
}

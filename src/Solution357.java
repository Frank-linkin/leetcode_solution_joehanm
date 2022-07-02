public class Solution357 {
    //09:44 - 10:02
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        for(int i = 1 ; i<=n; i++) {
            sum = sum +calculateNumsLeft(i);
        }
        return sum;
    }

    public int calculateNumsLeft(int n ) {
        if(n==1) {
            return 10;
        }
        int factor1 = 1;
        for(int i = 0 ; i< n ;i++) {
            factor1=factor1*2;
        }
        int factor2 = 1;
        for(int i = 0 ;i <n-1;i++) {
            factor2 = factor2*10;
        }
        System.out.printf("resp = %d\n",9*(factor2-(factor1-1-n)));
        return 9*(factor2-(factor1-1-n));
    }


    public static void main(String[] args) {
        Solution357 a= new Solution357();
        System.out.println(a.countNumbersWithUniqueDigits(3));
        System.out.println(Math.pow(2, 3));
    }
    /**
     * 3
     * C32 从3个槽选出来两个重复，选出来这两个位置后，然后又会有9种重复情况
     * C33 从3个槽选出3个重复，选出来位置后，又会有9种情况
     * 所以：
     *  当n=1时，不会重复，
     *  当n=2时， 一共有90个数，resp = 90 - C22*9 = 81
     *  当n=3时，一共有900个数，resp = 900 - c32*9 - c33*9 = 900 - (C32+C33)*9
     *  当n=4时，一共有9000个数，resp = 9000-(C42+C43+C44)*9
     *  1+2+1=4
     *  1+3+3+1=8
     *  4+6+4+1 = 16
     *
     *  9*10(n-1) - (2n - 1-n)*9
     *
     *  100 101 110 220 202 122
     *
     */
}

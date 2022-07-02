public class Solution309 {
    //21:24
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) {
            return 0;
        }
        int sum = 0;
        for(int a : prices) {
            sum+=a;
        }
        if((sum&1)==1) {

        }

        return 0;
    }


    public static void main(String[] args) {

    }
    /**
     *
     */
}

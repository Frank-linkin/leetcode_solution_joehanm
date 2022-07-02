public class Solution518 {
    //20:27 开始
    public int change(int amount, int[] coins) {
        if(coins==null||coins.length == 0 ) {
            return 0;
        }

        if(amount==0){
            return 1;
        }
        int[] dp =new int[amount+1];
        dp[0] = 1;
        for(int i = 0 ; i< coins.length; i++) {
            for(int j = coins[i];j<=amount;j++) {
                dp[j] = dp[j-coins[i]]+dp[j];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        Solution518 solution518 = new Solution518();
        System.out.println("Result = "+solution518.change(amount,coins));

    }
    /**
     * dp[i][j]表示使用前i个coins能生成总金额为j的总数
     * if j - coins[i]>=0
     *    dp[i][j] = dp[i][j-coins[i]]+dp[i-1][j]
     * 所以时间复杂度
     *  O(M*n)
     *  空间复杂度O(n)
     */
}

public class Solution518 {
    public int change(int amount, int[] coins) {
        if(amount == 0 ){
            return 1;
        }
        int[] dp = new int[amount+1];

        dp[0] = 1;
        for(int i = 0 ; i < coins.length ;i ++){
            for(int j =coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
            }
        }

        for(int i = 0 ; i < dp.length ; i++){
            System.out.println(dp[i]);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        Solution518 solution518 = new Solution518();
        System.out.println("Result = "+solution518.change(amount,coins));

    }
}

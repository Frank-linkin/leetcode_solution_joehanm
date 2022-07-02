public class Solution62 {
    public int uniquePaths(int m, int n) {
        if(m==0||n==0) {
            return 0;
        }
        if(m==1||n==1) {
            return 1;
        }

        int[] dp = new int[n];
        for(int i = 0 ; i< dp.length; i++) {
            dp[i] = 1;
        }
        for(int i = 0 ; i< m ; i++) {
            for(int j=  0 ; j<n ;j++) {
//                if(j==0&&i!=0){
//                    dp[j] = dp[j];
//                }
                if(i==0&&j!=0){
                    dp[j] = dp[j-1];
                }
                if(i!=0&&j!=0){
                    dp[j] = dp[j-1]+dp[j];
                }
            }
        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(3,7));
    }
    /**
     * 思路一：
     *      使用动态规划
     *      dp[m][n] = dp[m-1][n] + dp[m][n-1]
     */
}

public class Solution64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0||grid[0].length==0) {
            return 0;
        }

        int[] dp = new int[grid[0].length];
        for(int i = 0 ;  i< grid.length; i++ ) {
            for(int j = 0 ; j < grid[0].length; j++) {
                if(i==0&&j==0){
                    dp[j] = grid[0][0];
                }
                else if(i==0){
                    dp[j] = dp[j-1]+grid[i][j];
                }
                else if(j==0) {
                    dp[j] = dp[j] +grid[i][j];
                }
                else if(j!=0&&i!=0){
                    dp[j] = Math.min(dp[j-1],dp[j]) + grid[i][j];
                }
            }
        }
        return dp[grid[0].length-1];
    }

    public static void main(String[] args) {

    }

    /**
     *
     */
}

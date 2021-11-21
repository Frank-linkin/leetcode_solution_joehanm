public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int [m] [n];

        if(obstacleGrid[0][0] == 1){
            dp[0][0] = 0;
        }
        else{
            dp[0][0] = 1;
        }


        for(int i = 0 ; i < m ; i ++ ){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0 ){
                    continue;
                }

                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }
                else if( i == 0){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp [i] [j-1];
                }

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[] [] data = {{0,1,0,0},{0,0,0,0},{0,1,0,0}};
        Solution63 solution63 = new Solution63();
        System.out.println(solution63.uniquePathsWithObstacles(data));


//        boolean a = true;
//        if( a || data[-1][-1] == -1){
//            System.out.println("Enter In");
//        }
    }
}

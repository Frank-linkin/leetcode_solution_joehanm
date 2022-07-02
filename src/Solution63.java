public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if(obstacleGrid == null ||obstacleGrid.length==0||obstacleGrid[0].length==0) {
           return 0;
       }

       int[] dp =new int[obstacleGrid[0].length];
       dp[0] = 1;
       for(int i = 0 ; i< obstacleGrid.length; i++) {
           for(int j = 0 ; j< obstacleGrid[0].length ; j++) {
               if(obstacleGrid[i][j]==1) {
                   dp[j] = 0;
               }else{
//                   if(j==0&&i!=0){
//                       dp[j] = dp[j]
//                   }
                   if(i==0&&j!=0){
                       dp[j] = dp[j-1];
                   }
                   if(i!=0&&j!=0){
                       dp[j] = dp[j-1]+dp[j];
                   }
               }
           }
       }
       return dp[obstacleGrid[0].length-1];
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
    /**
     * 思路一：
     *      还是使用dp
     *      dp[m][n] = dp[m-1][n]+dp[m][n-1]
     *      if(obstacleGrid[m][n]==1)
     *          dp[m][n] = 0
     */
}

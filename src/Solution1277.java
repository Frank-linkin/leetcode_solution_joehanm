public class Solution1277 {
    public int countSquares(int[][] matrix) {
        if ( matrix == null || matrix.length == 0 ) {
            return 0;
        }

        //使用两个
        int count=0;
        int[][] dp = new int[2][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            int row = (i&1);
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 1) {
                    if(i==0||j==0) {
                        dp[row][j] = 1;
                    }else{
                        dp[row][j] = min(dp[row][j-1],dp[1-row][j-1],dp[1-row][j])+1;
                    }
                }else{
                    dp[row][j] = 0;
                }
                count+=dp[row][j];

            }
        }
        return count;
    }

    public int min(int a,int b, int c) {
        if(a<=b){
            if(a<=c){
                return a;
            }else{
                return c;
            }
            //a>b
        }else{
            if(b<=c){
                return b;
            }else{
                return c;
            }
        }
    }
    //20:00 开始
    public static void main(String[] args) {
        int[][] data = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        Solution1277 solution1277 = new Solution1277();

        System.out.println(solution1277.countSquares(data));
    }
    /**
     * dp[i][j]为以(i,j)为右下角的正方形的最大长度

     *
     * if matrix[i][j] == 1
     *    if i== 0 || j==0
     *      dp[i][j] = 1
     *    else
     *      dp[i][j] = min{dp[i-1][j],dp[i-1][j-1],dp[i][j-1]} +1
     *  else
     *    dp[i][j] = 0
     */
}

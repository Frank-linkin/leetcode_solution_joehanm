public class Solution85 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        };
        Solution85 a = new Solution85();
        System.out.println(a.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix==null)
            return 0;
        if(matrix[0]==null||matrix[0].length == 0 ){
            return 0;
        }
        int[][] dp = new int[2][matrix[0].length];

        int max = 0;
        int index = 0;
        for(int i = 0 ; i< matrix.length ; i++){
            for(int j= 0 ; j < matrix[0].length ; j++){
            //    System.out.printf("%c ",matrix[i][j]);
            }
            //System.out.println();
        }
        //System.out.println();

        for(int i = 0 ; i < matrix.length ; i++){
            index = i&1;
            for( int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    if(i==0&&j==0){
                        dp[index][j] = 1;
                    }
                    else if(i==0){
                        dp[index][j] = dp[index][j-1]+1;
                    }
                    else if(j==0){
                        dp[index][j] = dp[1-(index)][j]+1;
                    }
                    else{
                        if(dp[1-(index)][j-1]==0){
                            dp[index][j] = dp[index][j-1]>dp[1-(index)][j]?dp[index][j-1]+1:dp[1-(index)][j]+1;
                        }
                        else if(dp[index][j-1]==0){
                            dp[index][j] = 0;
                            for(int p = i ; p >=0&&matrix[p][j]=='1';p--){
                                dp[index][j]++;
                            }
                        }
                        else if(dp[1-(index)][j]==0){
                            dp[index][j] = 0;
                            for(int p = j; p>=0&&matrix[i][p]=='1';p--){
                                dp[index][j]++;
                            }
                        }
                        else{
                            dp[index][j] = dp[index][j-1]+dp[1-(index)][j]-dp[1-(index)][j-1]+1;
                        }
                    }
                }
                else{
                    dp[index][j] = 0;
                }
                max = max>dp[index][j]?max:dp[index][j];
                //System.out.printf("%d ",dp[index][j]);
            }
            //System.out.println();
        }
        return max;
    }
}

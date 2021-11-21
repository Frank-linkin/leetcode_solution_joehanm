public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        d[0][0]=1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i==0&&j==0){
                    continue;
                }
                else if(j == 0){
                    d[i][j] = d[i-1][j];
                }
                else if(i == 0 ){
                    d[i][j] = d[i][j-1];
                }
                else{
                    d[i][j]=d[i-1][j]+d[i][j-1];
                }
            }
        }
        return d[m-1][n-1];
    }


    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(3,7));
    }
}

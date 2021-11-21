public class Solution718 {
    public int findLength(int[] A, int[] B) {
        if(A==null || B==null){
            return 0;
        }
        if(A.length == 1){
            for(int i = 0 ; i < B.length ; i ++){
                if(A[0] == B[i]){
                    return 1;
                }
            }
            return 0;
        }
        else if(B.length == 1){
            for(int i = 0 ; i< A.length ; i++){
                if(B[0] == A[i]){
                    return 1;
                }
            }
            return 0;
        }

        int[][] dp = new int[2][B.length];
        int maxComLen = 0;
        int curRow = 0;
        for(int i = 0 ; i < A.length ; i++){
            curRow = i&1;
            for(int j = 0 ; j < B.length ; j++){
                if(A[i]!=B[j]){
                    dp[curRow][j] = 0;
                }
                else{
                    if(i==0||j==0){
                        dp[curRow][j] = 1;
                    }
                    else{
                        dp[curRow][j] = dp[1-curRow][j-1]+1;
                    }
                    if(dp[curRow][j] > maxComLen){
                        maxComLen = dp[curRow][j];
                    }
                }
     //           System.out.printf("%d ",dp[i][j]);
            }
        //    System.out.println();
        }
        return maxComLen;
    }

    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();

        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(solution718.findLength(A,B));
    }
}

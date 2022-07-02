import java.sql.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Solution474 {
    //19:43-开始
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length==0) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for(String a : strs) {
            int zeroNum = countZero(a);
            int oneNum = a.length()-zeroNum;

            for(int i = m ; i>=0 ;i--) {
                for(int j = n ; j>=0;j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int countZero(String s) {
        if(s==null) {
            return 0;
        }
        int count = 0;
        for(int i = 0 ; i< s.length();i++) {
            if(s.charAt(i)-'0'==0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution474 solution474 = new Solution474();

        String s = "11011";
        System.out.printf("%d",solution474.countZero(s));
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(solution474.findMaxForm(strs, m, n));
    }

    /**
     * 使用两个数组，dpm和dpn
     * dpm[t][p][q]:表示使用前t个strs，p个0，q个1，所拥有的最大子集的长度
     *
     * 考虑strs[i],dp[][][]
     * p>=count(0) q>=count(1)
     *  dp[i][p][q] = Max( dp[i-1][p-count(0)][q-count(1)]+1,dp[i-1][p][q] )
     * else
     *  dp[i][p][q] = dp[i-1][p][q]
     */
}

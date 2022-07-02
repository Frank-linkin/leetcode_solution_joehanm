public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //保持text2长度较小
        if(text1.length()<text2.length()){
            String tem = text1;
            text1 = text2;
            text2 = tem;
        }

        return 0;
    }

    public static void main(String[] args) {
        String a1 = "abcde";
        String a2 = "ace";

        Solution1143 solution1143 = new Solution1143();
        System.out.println(solution1143.longestCommonSubsequence(a1, a2));
    }
    /**
     * dp[i][j]表示text1的i位置和text2的j位置
     * if text1[i]==text2[j]
     *      if i==0 || j==0
     *          dp[i][j] = 1
     *      else
     *          dp[i][j] = dp[i][j-1]
     * else
     *     if i== 0&&j==0
     *          dp[i][j]=0;
     *     else if i==0
     *        dp[i][j] = dp[i][j-1]
     *     else if j==0
     *        dp[i][j] = dp[i-1][j]
     *     else
     *        dp[i][j] = dp[i-1][j-1]
     * 时间复杂度O(m*n）
     *  空间复杂度O(m);
     */
}

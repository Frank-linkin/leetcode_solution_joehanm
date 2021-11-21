public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(),l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];

        char c1 , c2;
        for(int i = 1 ; i <= l1 ;i++){
            for(int j = 1 ; j <= l2 ; j++){
                c1 = text1.charAt(i - 1);
                c2 = text2.charAt(j - 1);
                if(c1 == c2 ){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
                }
            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String a1 = "abcdexyze";
        String a2 = "oaxyzbcdexe";

        Solution1143 solution1143 = new Solution1143();
        System.out.println(solution1143.longestCommonSubsequence(a1, a2));
    }
}

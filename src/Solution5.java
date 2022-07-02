public class Solution5 {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) {
            return null;
        }
        int[] dp  = new int[s.length()];
        int max = 0;
        int left = 0;
        int right = 0;
        for(int i = s.length()-1;i>=0;i--) {
            char charI = s.charAt(i);
            for(int j = dp.length-1;j>=i;j--){
                char charJ =s.charAt(j);
                if(charI!=charJ){
                    dp[j]=0;
                }else{
                    if(j==i){
                        dp[j]=1;
                    }else if(j==i+1){
                        dp[j]=2;
                    }else{
                        if(dp[j-1]>0){
                            dp[j]=dp[j-1]+2;
                        }else{
                            dp[j]=0;
                        }
                    }
                    if(dp[j]>max){
                        left = i;
                        right = j;
                        max = dp[j];
                    }
                }
            }
//            System.out.printf("i=%d:",i);
//            for(int a:dp){
//                System.out.printf("%d ",a);
//            }
//            System.out.println();
        }
        if(max==0){
            return "";
        }
        return s.substring(left,right+1);
    }


    public static void main(String[] args) {
        String data  = "aacabdkacaa";
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome(data));
    }

    /**
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 思路一 动态规划：
     *      使用dp[i][j]表示s[i]-s[j]是否为回文子串
     *      if s[i]=s[j]
     *          if j==i    dp[i][j] = 1;
     *          if(j==i+1) dp[i][j] = 2;
     *          else j>i+1
     *               dp[i][j] = dp[i+1,j-1]+2;
     *      else
     *         dp[i][j]=0;
     *      时间复杂度O(n2)
     *      空间复杂度O(N)
     *      这种做法会超出时间限制
     * 思路二 没有O(n)的解法
     *   双指针
     *
     *
     */
}

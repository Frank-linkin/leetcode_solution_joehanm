public class Solution91 {
    //8:19 开始
    public int numDecodings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1) {
            if(s.charAt(0)=='0'){
                return 0;
            }
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int checkTwo = check(1,s);
        switch (checkTwo){
            case 0:
                dp[1] = 2;
                break;
            case 3:
            case 1:
                dp[1] = 0;
                break;
            default :
                dp[1] = 1;
        }

        for(int i = 2 ;i < s.length() ; i++) {
            int checkResult = check(i,s);
            if(checkResult==0) {
                dp[i] = dp[i-1]+dp[i-2];
            }else if(checkResult==1) {
                dp[i] = dp[i-2];
            }else{
                dp[i] = dp[i-1];

            }
        }
        for(int a:dp) {
            System.out.printf("%d ",a);
        }
        System.out.println();
        return dp[s.length()-1];
    }

    public int check(int index,String s) {
        int cur = s.charAt(index)-'0';
        int last = s.charAt(index-1)-'0';
        if(last==1) {
            return 0;
        }else if(last==2) {
            //处理2*
            if(cur>=1&&cur<=6){
                return 0;
            }else if(cur==0) {
                return 1;
            }else{
                return 2;
            }
        }else if(last==0) {
            return 3;
        }else{
            return 2;
        }
    }

    public static void main(String[] args) {
        String s = "12";
        Solution91 solution91 = new Solution91();

        System.out.println(solution91.numDecodings(s));
    }
    /**
     * 思路：
     * 考虑现在在考虑s[i],它的前一个字母是s[i-1]check表示检查s[i]
     *  check的具体内容：
     *      1.s[i-1]==1，return 0 对应dp[i]=dp[i-2]+dp[i-1        dp[1] = 2
     *      2.s[i-1]==2, if 1<=s[i]<6
     *                     return 0 ,对应dp[i]=dp[i-2]+dp[i-1]    dp[1] = 2
     *                   else s[i]=='0'
     *                      return 1,对应dp[i] = dp[i-2]          dp[1] = 0
     *                   else
     *                      return 2,对应dp[i] = dp[i-1]          dp[1] = 1
     *      3.s[i-1]==0
     *          return 3,dp[i]=dp[i-1]                           dp[1] = 0
     *
     *      4.else
     *                return 2 dp[i]=dp[i-1]                     dp[1] = 1
     */
}

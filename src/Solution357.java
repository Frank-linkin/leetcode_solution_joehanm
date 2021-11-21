public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        //处理一下边界情况
        if(n==0){
            return 1;
        }
        else if(n==1){
            return 10;
        }

        int[] dp = new int[n+1];
        dp[0] = 0 ; dp[1] = 0;
        for(int i = 2 ; i < dp.length;i++){
            dp[i] = 10*dp[i-1]+ (9*((int)Math.pow(10,i-2))-dp[i-1])*(i-1);
        }

        //System.out.println(dp[2]);
        int res = 0;
        for(int i= 2;i<dp.length;i++){
            res+=dp[i];
        }
        return ((int)Math.pow(10,n))-res;
    }


    public static void main(String[] args) {
        Solution357 a= new Solution357();
        System.out.println(a.countNumbersWithUniqueDigits(2));
        System.out.println(Math.pow(2, 3));
    }
}

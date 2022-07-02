public class Solution416 {
    //开始：11:13
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0) {
            return false;
        }
        if(nums.length==1) {
            return false;
        }

        int sum = 0;
        for(int a:nums){
            sum +=a;
        }
        if((sum&1)==1){
            return false;
        }
        sum = sum>>1;
        boolean[] dp = new boolean[sum+1];
        int max = 0;
        dp[0] = true;
        for(int i = 0 ; i<nums.length;i++) {
            max+=nums[i];
            for(int j =Math.min(max,sum);j>=nums[i];j--) {
                dp[j] = dp[j-nums[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        int[] data = {2,2,3,5};
        System.out.println(solution416.canPartition(data));
    }

    /**
     * 方案一：
     *      [1,5,11,5]
     *      [1,2,10,11]
            求出数组的和，如果和为奇数，直接returnfalse
     *      如果是偶数，看看能不能挑出几个数和和为total/2,记target = total/2
     *      dp[i]表示前i个数的和
     *      dp[i][j]表示利用前n个数生成和J
     *      当j<=nums[i]时
     *          dp[i][j] = dp[i-1][j]
     *      当j>nums[i]时
     *          dp[i][j] = dp[i][j-nums[i]]
     */
}

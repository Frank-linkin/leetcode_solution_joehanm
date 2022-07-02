public class Solution213 {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return 0;
        }

        int[] dp = new int[nums.length];
        //将nums[1]固定算到里面
        dp[0] = nums[0];
        dp[1] = nums[0];
        int max = -1;
        for(int i = 2; i< nums.length-1;i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            max = dp[i]>max?dp[i]:max;
        }
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for(int i = 3;i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            max = dp[i]>max?dp[i]:max;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();

        int[] data = {100,1,2,3,200};
        System.out.println(solution213.rob(data));
    }
    /**
     * 思路：
     *  第一次将100固定算到里面，计算最大rob金额,此时nums相当于最后一个数字去掉
     *  第二次将100剔除，计算最大rob金额，
     */
}

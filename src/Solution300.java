public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums== null || nums.length == 0 ) {
            return 0;
        }
        int[] dp =new int[nums.length];
        dp[0] = 1;
        int totalMax = 1;
        for(int i =1;i<nums.length; i++) {
            int max = 0;
            for(int j = 0 ;j<i;j++){
                if(nums[j]<nums[i]){
                    max = max<dp[j]?dp[j]:max;
                }
            }
            dp[i] = max+1;
            totalMax = totalMax<dp[i]?dp[i]:totalMax;
        }
        return totalMax;
    }

    public static void main(String[] args) {
        int[] data  = {10,9,2,5,3,7,101,18};
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS(data));
    }
    /**
     * 思路一 动态规划：
     *      设置一个动态规划数组dp[],dp[i]表示以i为末尾的最长严格递增子序列的长度
     *      dp[0]=1
     *      dp[i] = max(dp[t])+1 0<=t<=i-1,nums[t]<nums[i]
     *      时间复杂度O(n2)
     *      空间复杂度O(n)
     */
}

public class Solution494 {
    //21:43 开始 22:06结束
    public int findTargetSumWays(int[] nums, int target) {
        return countIndex(nums,nums.length-1,target);
    }

    public int countIndex(int[] nums,int index,int target) {
        int resp = 0;
        if(index==0){
            if(target-nums[index]==0){
                resp++;
            }
            if(target+nums[index]==0){
                resp++;
            }
            return resp;
        }

        resp += countIndex(nums,index-1,target-nums[index]);
        resp += countIndex(nums,index-1,target+nums[index]);
        return resp;
    }
    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int[] nums = {1,1,1,1,1};
        int S = 3;
        System.out.println(solution494.findTargetSumWays(nums, S));
    }
    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     *
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     *
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     *
     * 思路一 非动态规划：
     *  考虑nums[i],
     *  设置一个数组dp[target],dp[target] = dp[target-nums[i]] + dp[target+nums[i]]
     *  这次不使用数组，而是使用一个固定nums.length层的递归函数
     *  时间复杂度O(nums.length)
     *  countCombination(in
     *  思路二 动态规划
     *
     */
}

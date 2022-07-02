import org.junit.Test;

public class Solution198 {
    //11:06 开始
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        if(nums.length==1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i = 2; i< nums.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int max = -1;
        for(int a:dp){
            max = max<a?a:max;
        }
        return max;
    }

    @Test
    public void test1(){
        int[] data = {2,1,1,2};
        System.out.printf("%d ",rob(data));
    }
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 思路：
     *      毫无疑问，使用动态规划
     *      考虑第i个房屋
     *      dp[i] = max(dp[i-2]+nums[i],dp[i-1])
     *      再考虑极限情况
     *      num.length == 1
     *          不用选择，直接打劫
     *      nums.length == 2;
     *      2,1,1,2
     */
}

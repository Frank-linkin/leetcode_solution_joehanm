public class Solution198 {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        else if(nums.length==1){
            return nums[0];
        }
        else if(nums.length == 2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }


        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0]>nums[1]?nums[0]:nums[1];
        int temMax = 0;
        for(int i = 2 ; i < nums.length ;i ++ ){
            temMax = dp[i-2]+nums[i];
            dp[i] = temMax>dp[i-1]?temMax:dp[i-1];
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {

    }
}

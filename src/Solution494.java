public class Solution494 {
    //version1 202104
    public int findTargetSumWays_version1(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            if (S == nums[0] || S == -nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }

        int[][] dp = new int[2][2000 + 1];
        int bound = nums[0];
        if (nums[0] == 0) {
            dp[0][1000] = 2;
        } else {
            dp[0][1000 + nums[0]] = 1;
            dp[0][1000 - nums[0]] = 1;
        }

        int row = 1;
        for (int i = 1; i < nums.length; i++) {
            bound += nums[i];
            row = i & 1;
            for (int j = -bound; j <= bound; j++) {
                if (nums[i] <= j + 1000 && j + 1000 <= 2000 - nums[i]) {
                    dp[row][j + 1000] = dp[1 - row][j + 1000 - nums[i]] + dp[1 - row][j + 1000 + nums[i]];
                } else if (j + 1000 < nums[i]) {
                    dp[row][j + 1000] = dp[1 - row][j + 1000 + nums[i]];
                } else {
                    dp[row][j + 1000] = dp[1 - row][j + 1000 - nums[i]];
                }
                //System.out.printf("%d ",dp[row][j+1000]);
            }
            //System.out.println();
        }
        if (S > bound || S < -bound) {
            return 0;
        } else {
            return dp[row][S + 1000];
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = getSum(nums);
        int dif = sum - S;
        if ((dif & 1) == 1)
            return 0;
        dif = dif >> 1;
        int[][] dp = new int[nums.length][sum + 1];
        //初始化第一行，第一行只有一个数
        dp[0][nums[0]] = 1;
        dp[0][0]=1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if(j==0){
                    dp[i][j] = 1;
                }
                else if(j<nums[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][dif];
    }
    public int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int[] nums = {1,0};
        int S = 1;
        System.out.println(solution494.findTargetSumWays(nums, S));
    }
}

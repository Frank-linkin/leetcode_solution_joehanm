public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0 ; i<=target;i++) {
            for(int a :nums) {
                if(a+i<=target) {
                    dp[a+i] = dp[a+i]+dp[i];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution377 solution377 = new Solution377();
        int[] data = {1,2,3};
        int target = 4;
        System.out.println(solution377.combinationSum4(data,target));
    }
    /**
     * 1,2,3
     * 0 1 2 3 4
     * 1 1 1 1
     * 1 1 2 2 1
     * 1 1 2 4 3
     * 1 1 2 4 7
     */
}

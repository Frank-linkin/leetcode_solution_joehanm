public class Solution377 {
    //version 2021/04
    public int combinationSum4_version1(int[] nums, int target) {
        if(nums==null){
            return 0;
        }
        if(nums.length == 1){
            if(target == nums[0]){
                return 1;
            }
            else{
                return 0;
            }
        }

        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0 ; i <nums.length ;i ++){
            for(int j = nums[i] ; j<=target ; j++){
                dp[j] = 0;
                for(int t = i ;t>=0;t--){
                    if(j-nums[t]>=0){
                        dp[j]+=dp[j-nums[t]];
                    }
                }
            }
        }
        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for( int i= 0; i <= target ;i++) {
            for(int j = 0 ; j < nums.length ; j++ ) {
                if(nums[j]<=i){
                    dp[i]+=dp[i-nums[j]];
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
}

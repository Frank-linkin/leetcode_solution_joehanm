public class Solution416 {
    public boolean canPartition(int[] nums) {
        //首先考虑一些边界情况
        if(nums == null||nums.length==1||nums.length==0){
            return false;
        }
        else if(nums.length == 2){
            return nums[0] == nums[1];
        }
        else{
            int sum = 0 ;
            for(int i = 0 ; i < nums.length ;i ++ ){
                sum+=nums[i];
            }
            if( (sum&1)==1 ){
                return false;
            }
            else{
                int tnum = sum/2;
                boolean[] dp = new boolean[tnum+1];
                int bound = nums[0];
                dp[nums[0]] = true;
                dp[0] = true;
                for(int i = 1 ; i<nums.length ;i ++){
                    for(int j = tnum ; j>=nums[i] ; j-- ){
                        if(dp[j-nums[i]]==true){
                            //System.out.println(" j = "+j);
                            dp[j] = true;
                        }
                    }
                }
                return dp[tnum];
            }
        }
    }

    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        int[] data = {2,2,3,5};
        System.out.println(solution416.canPartition(data));
    }
}

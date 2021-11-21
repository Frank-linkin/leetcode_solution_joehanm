public class Solution53 {
    public int maxSubArray1(int[] nums) {
        int maxValue = 0;
        int [][] a = new int[nums.length][nums.length];
        for(int i = 0 ;i<nums.length;i++){
            for(int j=i; j <nums.length;j++){
                if(i==j){
                    a[i][j]=nums[j];
                }
                else{
                    a[i][j]=a[i][j-1]+nums[j];
                }
                if(a[i][j]>maxValue){
                    maxValue = a[i][j];
                }
            }
        }
        return maxValue;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums==null){
            return 0;
        }

        dp[0] = nums[0];
        int tem = 0;
        for(int i=1;i<nums.length;i++){
            tem = dp[i-1]+nums[i];
            dp[i] = tem>nums[i]?tem:nums[i];
        }

        int maxValue = dp[0];
        for(int i =1 ;i<dp.length;i++){
            if(dp[i]>maxValue){
                maxValue = dp[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] data = {-2,1,-3,4,-1,2,1,-5,4};

        Solution53 solution = new Solution53();
        System.out.println(solution.maxSubArray(data));
    }
}

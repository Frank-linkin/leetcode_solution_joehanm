public class Solution55 {
    //21:26
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0) {
            return false;
        }
        if(nums[0]==0){
            return false;
        }
        int maxReach = nums[0];
        for(int i = 1 ; i< nums.length&&i<=maxReach;i++) {
            if(i+nums[i]>maxReach) {
                maxReach = i+ nums[i];
                if(maxReach>=nums.length-1){
                    return true;
                }
            }
        }
        if(maxReach>=nums.length-1){
            return true;
        }
        return false;
    }
    /**
     * 记录一个MaxReach
     * i>maxReach
     *   break;
     * maxReach >= nums.length-1
     *  return true;
     */
}

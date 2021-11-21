public class Solution55 {
    public boolean canJump(int[] nums) {
        int farest = 0;
        for(int i = 0 ; i < nums.length ; i++ ){
            if(i>farest){
                return false;
            }

            if(i+nums[i]>farest){
                farest = ( i + nums[i] );
            }
            if(farest > nums.length){
                return true;
            }
        }

        return true;
    }
}
